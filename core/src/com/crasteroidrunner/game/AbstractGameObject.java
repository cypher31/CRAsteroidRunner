package com.crasteroidrunner.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

//Base for objects that will be rendered

public abstract class AbstractGameObject {
	
	public Vector2 position;
	public Vector2 dimension;
	public Vector2 origin;
	public Vector2 scale;
	public float rotation;
	
	public Vector2 velocity;
	public Vector2 terminalVelocity;
	public Vector2 friction;
	public Vector2 acceleration;
	public Rectangle bounds;
	
	public Body body;
	
	public AbstractGameObject(){
		
		position = new Vector2();
		dimension = new Vector2(1,1);
		origin = new Vector2();
		scale = new Vector2(1,1);
		rotation = 0;
		
		velocity = new Vector2();
		terminalVelocity = new Vector2(1, 1);
		friction = new Vector2();
		acceleration = new Vector2();
		bounds = new Rectangle();
	}
	
	public void update(float deltaTime){
		if(body == null){
			updateMotionX(deltaTime);
			updateMotionY(deltaTime);
			//move to new position
			position.x += velocity.x * deltaTime;
			position.y += velocity.y * deltaTime;
		} else{
			position.set(body.getPosition());
			rotation = body.getAngle() * MathUtils.radiansToDegrees;
		}
	}
	
	public abstract void render(SpriteBatch batch);
	
	protected void updateMotionX(float deltaTime){
		if(velocity.x != 0){
			//apply friction -- this is from the canyon bunny demo
			//however this will be in space...no friction
			//instead the player will control acceleration/deceleration directly
		}
		//apply acceleration
		velocity.x += acceleration.x * deltaTime;
		//make sure objects velocity does not excede terminal velocity
		velocity.x = MathUtils.clamp(velocity.x, -terminalVelocity.x, terminalVelocity.y);
	}
	
	protected void updateMotionY(float deltaTime){
		if(velocity.y != 0){
			//apply friction -- this is from the canyon bunny demo
			//however this will be in space...no friction and no gravity
			//instead the player will control acceleration/deceleration directly
		}
		//apply acceleration -- no acceleration, we are in space
	}

}
