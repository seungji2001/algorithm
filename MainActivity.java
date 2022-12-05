package mobile.example.sensorlistenertest;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	final String TAG = "SensorTest";

	private TextView tvText;

	SensorManager sensorManager;
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
			Log.d(TAG, "Sensing Start!");
			//버튼 누르면
			
			Sensor sensorType = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
			//센서가 null인지 아닌지의 여부를 확인하는 과정이ㅡ생략 되었으나 필요하다
			int sensorDelay = SensorManager.SENSOR_DELAY_UI;
			sensorManager.registerListener(sensorEventListener,sensorType,sensorDelay);
			break;
		}
	}
	
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d(TAG, "Sensing Stop!");
		sensorManager.unregisterListener(sensorEventListener);
	}
	
	SensorEventListener sensorEventListener = new SensorEventListener() {
		@Override
		public void onSensorChanged(SensorEvent sensorEvent) {
			//센싱한 결과가 들어온다. values로 센싱한 결과가 들어온다.
			String data = String.format("Value : %f",sensorEvent.values[0]);
			 tvText.setText(data);

		}

		@Override
		public void onAccuracyChanged(Sensor sensor, int i) {

		}
	};
}
