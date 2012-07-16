package jhekasoft.lotto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        
        if(Lotto.NUMBERS_END != nextNumber) {
            textViewNumber.setText(String.valueOf(nextNumber));
            editTextNumberHistory.setText(editTextNumberHistory.getText() + String.valueOf(nextNumber) + ", ");
        }
    }
}
