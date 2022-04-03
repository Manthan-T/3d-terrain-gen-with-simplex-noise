package com.github.mrfirekiller.flight_simulator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.utils.UBJsonReader;

public class FlightSimulator extends ApplicationAdapter {

	private PerspectiveCamera camera;
	private ModelBatch batch;
	private Model plane;
	private ModelInstance selfPlane;
	private Environment environment;

	@Override
	public void create() {
		camera = new PerspectiveCamera(90, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(0, 100, -100);
		camera.lookAt(0, 100, 0);
		camera.near = 0.1f;
		camera.far = 100;

		batch = new ModelBatch();
		UBJsonReader jsonReader = new UBJsonReader();
		G3dModelLoader modelLoader = new G3dModelLoader(jsonReader);
		plane = modelLoader.loadModel(Gdx.files.getFileHandle("models/plane/plane.g3db", Files.FileType.Internal));

		selfPlane = new ModelInstance(plane);

		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, Color.WHITE));
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT|GL20.GL_DEPTH_BUFFER_BIT);

		camera.update();

		batch.begin(camera);
			batch.render(selfPlane, environment);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		plane.dispose();
	}

}
