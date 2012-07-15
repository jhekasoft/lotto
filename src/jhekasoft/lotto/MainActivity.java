package jhekasoft.lotto;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity
{
    private TextView textViewNumber;
    private EditText editTextNumberHistory;
    private Lotto lotto;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        textViewNumber = (TextView)findViewById(R.id.textViewNumber);
        editTextNumberHistory = (EditText)findViewById(R.id.editTextNumberHistory);
        lotto = new Lotto();
    }
    
    public void buttonNextNumber_Click(View view){
        int nextNumber = lotto.getNextNumber();
        
        if(Lotto.NUMBERS_END != nextNumber) {
            textViewNumber.setText(String.valueOf(nextNumber));
            editTextNumberHistory.setText(editTextNumberHistory.getText() + String.valueOf(nextNumber) + ", ");
        }
    }
}
