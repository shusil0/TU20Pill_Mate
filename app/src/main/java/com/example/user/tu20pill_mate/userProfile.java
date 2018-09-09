package com.example.user.tu20pill_mate;

import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.user.tu20pill_mate.data.AlarmReminderContract;
import com.example.user.tu20pill_mate.reminder.AlarmScheduler;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

public class userProfile extends AppCompatActivity implements android.app.LoaderManager.LoaderCallbacks<Cursor> {

    private Toolbar toolbarr;
    private EditText firstName;
    private EditText lastName;
    private EditText age;
    private EditText bloodType;
    private EditText allergies;
    private EditText weight;
    private EditText height;

    private static final int EXISTING_VEHICLE_LOADER = 0;


    private String firstNam;
    private String secondNam;
    private String ag;
    private String bloodTyp;
    private String allergie;
    private String weigh;
    private String heigh;


    private Uri mCurrentReminderUri;


    // Values for orientation change
    private static final String KEY_FIRST_NAME = "first_name_key";
    private static final String KEY_LAST_NAME = "last_name_key";
    private static final String KEY_AGE = "age_key";
    private static final String KEY_BLOOD_TYPE = "blood_type_key";
    private static final String KEY_WEIGHT = "weight_key";
    private static final String KEY_ALLERGIES = "allergies_key";

    private static final String KEY_HEIGHT = "height_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Intent intent = getIntent();
        mCurrentReminderUri = intent.getData();

        if (mCurrentReminderUri == null) {

            setTitle(getString(R.string.prof));

            // Invalidate the options menu, so the "Delete" menu option can be hidden.
            // (It doesn't make sense to delete a reminder that hasn't been created yet.)
            invalidateOptionsMenu();
        } else {

            setTitle(getString(R.string.editor_activity_title_edit_reminder));


            getLoaderManager().initLoader(EXISTING_VEHICLE_LOADER, null, this);
        }


        toolbarr = (Toolbar) findViewById(R.id.toolbar);
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        age = (EditText) findViewById(R.id.age);
        bloodType = (EditText) findViewById(R.id.bloodType);
        allergies = (EditText) findViewById(R.id.allergies);
        weight = (EditText) findViewById(R.id.weight);
        height = (EditText) findViewById(R.id.height);

      /*  //Defaults
        firstNam = "N/A";
        secondNam = "N/A";
        ag = "N/A";
        allergie = "N/A";
        bloodTyp = "N/A";
        weigh = "N/A";
        heigh = "N/A";
*/

        // Setup Instructions EditText
        firstName.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                firstNam = s.toString().trim();
                firstName.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        lastName.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                secondNam = s.toString().trim();
                lastName.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        allergies.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                allergie = s.toString().trim();
                allergies.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        age.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ag = s.toString().trim();
                age.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        bloodType.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bloodTyp = s.toString().trim();
                bloodType.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        weight.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                weigh = s.toString().trim();
                weight.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        height.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                heigh = s.toString().trim();
                height.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        firstName.setText(firstNam);
        age.setText(ag);
        bloodType.setText(bloodTyp);
        allergies.setText(allergie);
        weight.setText(weigh);
        height.setText(heigh);
        lastName.setText(secondNam);
        setSupportActionBar(toolbarr);
        //setSupportActionBar(toolbar);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putCharSequence(KEY_AGE, age.getText());
        outState.putCharSequence(KEY_BLOOD_TYPE, bloodType.getText());
        outState.putCharSequence(KEY_ALLERGIES, allergies.getText());
        outState.putCharSequence(KEY_FIRST_NAME, firstName.getText());
        // outState.putCharSequence(KEY_EXPIRY_DATE, mExpiryDateText.getText());
        outState.putCharSequence(KEY_HEIGHT, height.getText());
        outState.putCharSequence(KEY_LAST_NAME, lastName.getText());
        outState.putCharSequence(KEY_WEIGHT, weight.getText());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_add_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.save_reminder:


                saveReminder();
                finish();

                return true;

        }

        return super.onOptionsItemSelected(item);

    }


    public void saveReminder() {

        ContentValues values = new ContentValues();


        values.put(AlarmReminderContract.AlarmReminderEntry.FIRST_NAME, firstNam);
        values.put(AlarmReminderContract.AlarmReminderEntry.SECOND_NAME, secondNam);
        values.put(AlarmReminderContract.AlarmReminderEntry.ALLERGIES, allergie);
        values.put(AlarmReminderContract.AlarmReminderEntry.AGE, ag);
        values.put(AlarmReminderContract.AlarmReminderEntry.BLOOD_TYPE, bloodTyp);
        values.put(AlarmReminderContract.AlarmReminderEntry.WEIGHT, weigh);
        values.put(AlarmReminderContract.AlarmReminderEntry.HEIGHT, heigh);

        Log.i("Testing", firstNam);

    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {
                AlarmReminderContract.AlarmReminderEntry.FIRST_NAME,
                AlarmReminderContract.AlarmReminderEntry.SECOND_NAME,
                AlarmReminderContract.AlarmReminderEntry.ALLERGIES,
                AlarmReminderContract.AlarmReminderEntry.AGE,
                AlarmReminderContract.AlarmReminderEntry.BLOOD_TYPE,
                AlarmReminderContract.AlarmReminderEntry.WEIGHT,
                AlarmReminderContract.AlarmReminderEntry.HEIGHT,

        };

        // This loader will execute the ContentProvider's query method on a background thread
        return new CursorLoader(this,   // Parent activity context
                mCurrentReminderUri,         // Query the content URI for the current reminder
                projection,             // Columns to include in the resulting Cursor
                null,                   // No selection clause
                null,                   // No selection arguments
                null);                  // Default sort order

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {


        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        // Proceed with moving to the first row of the cursor and reading data from it
        // (This should be the only row in the cursor)
        if (cursor.moveToFirst()) {
            int firstNameColumnIndex = cursor.getColumnIndex(AlarmReminderContract.AlarmReminderEntry.FIRST_NAME);
            int lastNameColumnIndex = cursor.getColumnIndex(AlarmReminderContract.AlarmReminderEntry.SECOND_NAME);
            int ageColumnIndex = cursor.getColumnIndex(AlarmReminderContract.AlarmReminderEntry.AGE);
            int allergiesColumnIndex = cursor.getColumnIndex(AlarmReminderContract.AlarmReminderEntry.ALLERGIES);
            int bloodTypeColumnIndex = cursor.getColumnIndex(AlarmReminderContract.AlarmReminderEntry.BLOOD_TYPE);
            int weightColumnIndex = cursor.getColumnIndex(AlarmReminderContract.AlarmReminderEntry.WEIGHT);
            int heightColumnIndex = cursor.getColumnIndex(AlarmReminderContract.AlarmReminderEntry.HEIGHT);


            // Extract out the value from the Cursor for the given column index
            String fName = cursor.getString(firstNameColumnIndex);
            String lName = cursor.getString(lastNameColumnIndex);
            String aaa = cursor.getString(ageColumnIndex);
            String bloodTy = cursor.getString(bloodTypeColumnIndex);
            String allerg = cursor.getString(allergiesColumnIndex);
            String weig = cursor.getString(weightColumnIndex);
            String heig = cursor.getString(heightColumnIndex);


            // Update the views on the screen with the values from the database
            firstName.setText(fName);
            lastName.setText(lName);
            weight.setText(weig);
            height.setText(heig);
            bloodType.setText(bloodTy);
            // mExpiryDateText.setText(expiryDate);
            allergies.setText(allerg);
            age.setText(aaa);


        }


    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
