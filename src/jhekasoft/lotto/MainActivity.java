package jhekasoft.lotto;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{
    private TextView textViewNumber;
    private TextView textViewJargon;
    private TextView textViewStep;
    private EditText editTextNumberHistory;
    private Lotto lotto;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        textViewNumber = (TextView)findViewById(R.id.textViewNumber);
        textViewJargon = (TextView)findViewById(R.id.textViewJargon);
        textViewStep = (TextView)findViewById(R.id.textViewStep);
        editTextNumberHistory = (EditText)findViewById(R.id.editTextNumberHistory);
        lotto = new Lotto();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) 
    {
        // Операции для выбранного пункта меню
        switch (item.getItemId()) 
        {
        case R.id.about:
            showAbout();
            return true;
        case R.id.exit:
            exit();
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    
    public void showAbout() {
        Intent i = new Intent(this, AboutActivity.class);
        startActivity(i);
    }
    
    public void exit() {
        System.exit(0);
    }
    
    public void buttonNextNumber_Click(View view){
        int nextNumber = lotto.getNextNumber();
        String nextNumberText = String.valueOf(nextNumber);
        
        if(!lotto.isCurrentNumberFirst()) {
            nextNumberText = ", " + nextNumberText;
        }
        
        if(lotto.isCurrentNumberLast()) {
            nextNumberText += ".";
        }
        
        if(Lotto.NUMBERS_END != nextNumber) {
            textViewNumber.setText(String.valueOf(nextNumber));
            
            Resources res = getResources();
            String[] numbers_jargon = res.getStringArray(R.array.numbers_jargon);
            
            textViewJargon.setText(numbers_jargon[nextNumber]);
            
            textViewStep.setText(String.valueOf(lotto.getCurrentStep() + " "
                                               + getString(R.string.of) + " "
                                               + lotto.getNumbersCount()));
            
            editTextNumberHistory.setText(editTextNumberHistory.getText() + nextNumberText);
        } else {
            Toast toast = Toast.makeText(this, getString(R.string.game_over), Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
