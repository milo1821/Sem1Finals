package lab1.example.com.lab1;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends ActionBarActivity {

 double costPerTicket = 250.00;
    int numberOfTickets;
   double totalCost;
    String groupChoice;

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);



        tabHost=(TabHost)findViewById(R.id.tabHost);
        tabHost.setup();

        TabSpec spec1=tabHost.newTabSpec("Tigers!");
        spec1.setContent(R.id.Tigers);
        spec1.setIndicator("Tigers!");


        TabSpec spec2=tabHost.newTabSpec("Games");
        spec2.setIndicator("Games");
        spec2.setContent(R.id.Games);


        TabSpec spec3=tabHost.newTabSpec("Tickets");
        spec3.setContent(R.id.Tickets);
        spec3.setIndicator("Tickets");
        tabHost.addTab(spec1);
        tabHost.addTab(spec2);
        tabHost.addTab(spec3);

        final EditText tickets = (EditText)findViewById(R.id.txtNoTickets);
        final Spinner Group = (Spinner) findViewById(R.id.txtGroup);
        Button cost = (Button) findViewById(R.id.ticketcost);
        final TextView result = ((TextView)findViewById(R.id.txtResult));


        cost.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                numberOfTickets = Integer.parseInt(tickets.getText().toString());
                totalCost= costPerTicket*numberOfTickets;
                DecimalFormat currency = new DecimalFormat("Php###,###.##");
                groupChoice = Group.getSelectedItem().toString();
                result.setText("Seat: "+groupChoice+"\n Cost: "+currency.format(totalCost) + "\nWhere to buy: TYK and Araneta Coliseum" );    //result.setText("You selected "+groupChoice+" !!! ");
            }
        });



        final Spinner Grup = (Spinner) findViewById(R.id.selectTiger);
        Button tigerpro = (Button) findViewById(R.id.tigerenter);
        final TextView reslt = ((TextView)findViewById(R.id.tigerResult));
        final EditText tigername = (EditText) findViewById(R.id.tigerText);
        tigerpro.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                groupChoice = Grup.getSelectedItem().toString();
                reslt.setText("Player: " +groupChoice+ "\nPosition: All positions \nProfile: "+groupChoice+" plays at his best every game.");    //result.setText("You selected "+groupChoice+" !!! ");

            }
        });


        final Spinner oppo = (Spinner) findViewById(R.id.selectFoe);
        Button fight = (Button) findViewById(R.id.fight);
        final TextView reslt2 = ((TextView) findViewById(R.id.foeResult));
        fight.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                groupChoice = oppo.getSelectedItem().toString();
                reslt2.setText("UST vs " +groupChoice+ "\n Date: September 18, 2014 \n Where: Araneta Coliseum ");
            }
        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}



