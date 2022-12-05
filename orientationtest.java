package mobile.example.orientationtest;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

	private TextView tvText;
	SensorManager sensorManager;

	float[] mGravity;
	float[] mGeomagnetic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tvText = findViewById(R.id.tvText);
		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

	}

	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.btnStart:
			Sensor aceelrometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
			Sensor magnet = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

			int sensorDelay = SensorManager.SENSOR_DELAY_UI;
			//센서값이 막 들어오고, 섞여서 magne이 들어올 수도,acc가 들어올 수도있다
			sensorManager.registerListener(sensorEventListener,aceelrometer,sensorDelay);
			sensorManager.registerListener(sensorEventListener,magnet,sensorDelay);

			break;
		}
	}
	
	
	@Override
	protected void onPause() {
		super.onPause();
		sensorManager.unregisterListener(sensorEventListener);
	}

	SensorEventListener sensorEventListener = new SensorEventListener() {
		@Override
		public void onSensorChanged(SensorEvent event) {
			//clone - 복제 float, event배열을 복제하겠다는 의미이다. event가 참조로 들어오고 값을 보관하기 위해서 clone 이란 메소드를 사용하여, 복제본을 가리키도록한

			//mGravity와 mGeomagnetic의 값이 들어온다
			if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) mGravity = event.values.clone();
			if(event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) mGeomagnetic = event.values.clone();

			//둘의 값이모두 채워졌을때 수행하라는 의미
			if(mGravity != null && mGeomagnetic != null){
				float rotationMatrix[] = new float[9];
				//roatationMatrix =>9개의 방을 가지고 있는데 매개변수로 해당 방을 채운다
				boolean success = SensorManager.getRotationMatrix(rotationMatrix,null,mGravity,mGeomagnetic);

				//만약 방을 채웠다면
				if(success){
					float values[] = new float[3];
					//실제 값을 values에 넣어준다
					SensorManager.getOrientation(rotationMatrix, values);
					for(int i = 0; i<values.length; i++){
						//radian 값을 degrees로 바꾸기
						Double degrees = Math.toDegrees(values[i]);
						values[i] = degrees.floatValue();
					}
					//values 0번은 각
					float azimuth = values[0];
					float pitch = values[1];
					float roll = values[2];

					String result = String.format(Locale.KOREA, "azimuth : %f\npitch:%f\nroll:%f",azimuth,pitch,roll);

//					String result = String.format(Locale.KOREA, "azimuth : %f\npitch:%f\nroll:%f",values[0],values[1],values[2]);


					tvText.setText(result);
				}
			}

		}

//		private String getDirectionFromDegrees(float value) {
//
//		}

		@Override
		public void onAccuracyChanged(Sensor sensor, int i) {

		}
	};
	
}
