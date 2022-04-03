package com.github.mrfirekiller.flight_simulator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class FlightSimulator extends ApplicationAdapter {
	private PerspectiveCamera camera;
	private ModelBatch batch;
	private ModelBuilder builder;
	private Model box;
	private ModelInstance instance;
	private Environment environment;
	
	@Override
	public void create () {
		camera = new PerspectiveCamera(90, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(0, 0, -3);
		camera.lookAt(0, 0, 0);
		camera.near = 0.1f;
		camera.far = 100;

		batch = new ModelBatch();
		builder = new ModelBuilder();
		box = new Model(2, 2, 2, new Material(ColorAttribute.createDiffuse(Color.RED)), VertexAttributes.Usage.Position|VertexAttributes.Usage.Normal);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT|GL20.GL_DEPTH_BUFFER_BIT);
	}
}
