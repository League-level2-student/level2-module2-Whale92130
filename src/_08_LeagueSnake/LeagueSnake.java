package _08_LeagueSnake;

import java.util.ArrayList;

import processing.core.PApplet;

public class LeagueSnake extends PApplet {
	static final int WIDTH = 800;
	static final int HEIGHT = 800;

	/*
	 * Game variables
	 * 
	 * Put all the game variables here.
	 */
	Segment head;
	int foodX;
	int foodY;
	int direction = UP;
	int numberOfFood = 0;
	ArrayList<Segment> tail = new ArrayList<Segment>();

	/*
	 * Setup methods
	 * 
	 * These methods are called at the start of the game.
	 */
	@Override
	public void settings() {
		size(WIDTH, HEIGHT);
	}

	@Override
	public void setup() {
		head = new Segment(250, 250);
		frameRate(20);
		dropFood();
	}

	void dropFood() {
		// Set the food in a new random location
		foodX = ((int) random(50) * 10);
		foodY = ((int) random(50) * 10);

	}

	/*
	 * Draw Methods
	 * 
	 * These methods are used to draw the snake and its food
	 */

	@Override
	public void draw() {
		background(0, 0, 0);
		drawFood();
		move();
		drawSnake();
		eat();
	}

	void drawFood() {
		// Draw the food
		fill(255, 0, 0);
		rect(foodX, foodY, 10, 10);

	}

	void drawSnake() {
		// Draw the head of the snake followed by its tail
		fill(0, 255, 0);
		rect(head.x, head.y, 10, 10);
		manageTail();
	}

	void drawTail() {
		// Draw each segment of the tail
		for (int i = 0; i < tail.size(); i++) {
			Segment segment = tail.get(i);
			rect(segment.x, segment.y, 10, 10);
		}

	}

	/*
	 * Tail Management methods
	 * 
	 * These methods make sure the tail is the correct length.
	 */

	void manageTail() {
		// After drawing the tail, add a new segment at the "start" of the tail and
		// remove the one at the "end"
		// This produces the illusion of the snake tail moving.
		checkTailCollision();
		drawTail();
		tail.add(new Segment(head.x, head.y));
		tail.remove(0);
	}

	void checkTailCollision() {
		// If the snake crosses its own tail, shrink the tail back to one segment
		for(int i =0;i<tail.size(); i++) {
			Segment seg = tail.get(i);
		if (head.x == seg.x && head.y == seg.y) {
			tail.remove(0);
		}
		}
	}

	/*
	 * Control methods
	 * 
	 * These methods are used to change what is happening to the snake
	 */

	@Override
	public void keyPressed() {
		// Set the direction of the snake according to the arrow keys pressed
		if (keyCode == UP) {
			direction = UP;
		} else if (keyCode == DOWN) {
			direction = DOWN;
		} else if (keyCode == LEFT) {
			direction = LEFT;
		} else if (keyCode == RIGHT) {
			direction = RIGHT;
		}
	}

	void move() {
		// Change the location of the Snake head based on the direction it is moving.
		if (direction == UP) {
			// Move head up
			head.y = head.y - 10;
			checkBoundaries();
		} else if (direction == DOWN) {
			// Move head down
			head.y = head.y + 10;
			checkBoundaries();
		} else if (direction == LEFT) {
			head.x = head.x - 10;
			checkBoundaries();
		} else if (direction == RIGHT) {
			head.x = head.x + 10;
			checkBoundaries();
		}

	}

	void checkBoundaries() {
		// If the snake leaves the frame, make it reappear on the other side
		if (head.y >= HEIGHT) {
			head.y = head.y - HEIGHT;
		}
		if (head.y <= 0) {
			head.y = head.y + HEIGHT;
		}
		if (head.x >= WIDTH) {
			head.x = head.x - WIDTH;
		}
		if (head.x <= 0) {
			head.x = head.x + WIDTH;
		}
	}

	void eat() {
		// When the snake eats the food, its tail should grow and more
		// food appear
		if (head.x == foodX && head.y == foodY) {
			dropFood();
			tail.add(new Segment(head.x, head.y));
		}
	}

	static public void main(String[] passedArgs) {
		PApplet.main(LeagueSnake.class.getName());
	}
}
