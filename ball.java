package mobile.example.movingballtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

	BallView ballView;
	SensorManager sensorManager;

	float[] mGravity;
	float[] mGeomagnetic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
		ballView = new BallView(this);
		setContentView(ballView);

		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

	}


	@Override
	protected void onPause() {
		super.onPause();
		sensorManager.unregisterListener(sensorEventListener);
	}


	@Override
	protected void onResume() {
		super.onResume();
		Sensor aceelrometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		Sensor magnet = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
		Sensor light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

		int sensorDelay = SensorManager.SENSOR_DELAY_UI;
		//센서값이 막 들어오고, 섞여서 magne이 들어올 수도,acc가 들어올 수도있다
		sensorManager.registerListener(sensorEventListener, aceelrometer, sensorDelay);
		sensorManager.registerListener(sensorEventListener, magnet, sensorDelay);
		sensorManager.registerListener(sensorEventListener,light,sensorDelay);
	}


	class BallView extends View {

		Paint paint;

		int width;
		int height;

		int x;
		int y;
		int r;

		boolean isStart;

		//공의 좌표를 센싱한 값에 따라서 바꿔주면 된다.
		public BallView(Context context) {
			super(context);
			paint = new Paint();
			paint.setColor(Color.RED);
			paint.setAntiAlias(true);
			isStart = true;
			r = 100;
		}

		public void onDraw(Canvas canvas) {
			if (isStart) {
				width = canvas.getWidth();
				height = canvas.getHeight();
				x = width / 2;
				y = height / 2;
				isStart = false;
			}

			canvas.drawCircle(x, y, r, paint);
		}

	}


	SensorEventListener sensorEventListener = new SensorEventListener() {
		@Override
		public void onSensorChanged(SensorEvent event) {
			//clone - 복제 float, event배열을 복제하겠다는 의미이다. event가 참조로 들어오고 값을 보관하기 위해서 clone 이란 메소드를 사용하여, 복제본을 가리키도록한

			//mGravity와 mGeomagnetic의 값이 들어온다
			if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
				mGravity = event.values.clone();
			if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
				mGeomagnetic = event.values.clone();

			if(event.sensor.getType() == Sensor.TYPE_LIGHT)
			//둘의 값이모두 채워졌을때 수행하라는 의미
			if (mGravity != null && mGeomagnetic != null) {
				float rotationMatrix[] = new float[9];
				//roatationMatrix =>9개의 방을 가지고 있는데 매개변수로 해당 방을 채운다
				boolean success = SensorManager.getRotationMatrix(rotationMatrix, null, mGravity, mGeomagnetic);

				//만약 방을 채웠다면
				if (success) {
					float values[] = new float[3];
					//실제 값을 values에 넣어준다
					SensorManager.getOrientation(rotationMatrix, values);
					for (int i = 0; i < values.length; i++) {
						//radian 값을 degrees로 바꾸기
						Double degrees = Math.toDegrees(values[i]);
						values[i] = degrees.floatValue();
					}

					//values 0번은 각
					if (values[1]>0){
						ballView.y -= 5;
					}else{
						ballView.y += 5;
					}
					if(values[2]>0){
						ballView.x += 5;
					}
					else{
						ballView.x -= 5;
					}

					ballView.invalidate();
				}
			}
		}

		@Override
		public void onAccuracyChanged(Sensor sensor, int i) {

		}
	};
}
