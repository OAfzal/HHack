package com.example.android.hhack;

//Imports the Google Cloud client library

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.QueryJobConfiguration;

import java.util.UUID;

public class QuickstartSample extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        TextView t1 = findViewById(R.id.query);
        try {
            Job date;
            date = getData();
            t1.setText(date.toString());

        } catch (Exception ex) {
            Log.e("QuickStartSample.java", ex.getLocalizedMessage());
        }
    }

    public Job getData() throws Exception {
        // Instantiate a client. If you don't specify credentials when constructing a client, the
        // client library will look for credentials in the environment, such as the
        // GOOGLE_APPLICATION_CREDENTIALS environment variable.
        BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

        String datasetName = "hackathon-hajj.pilgrims_entry_exit.entry_exit_table";

//        String query = "SELECT FIRST_NAME, AGE FROM "+dataset+" WHERE AGE>40 ORDER BY GENDER LIMIT 10"
//        QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).build();

        // The name for the new dataset

        // Fetches the dataset
        Dataset dataset = bigquery.getDataset(datasetName);
        System.out.printf("Dataset %s fetched.%n", dataset.getDatasetId().getDataset());

        QueryJobConfiguration queryConfig =
                QueryJobConfiguration.newBuilder(
                        "SELECT "
                                + "FIRST_NAME, "
                                + "AGE "
                                + "FROM " + " hackathon-hajj.pilgrims_entry_exit.entry_exit_table"
                                + " WHERE AGE >40 "
                                + "ORDER BY GENDER LIMIT 10")
                        // Use standard SQL syntax for queries.
                        // See: https://cloud.google.com/bigquery/sql-reference/
                        .setUseLegacySql(false)
                        .build();

// Create a job ID so that we can safely retry.
        JobId jobId = JobId.of(UUID.randomUUID().toString());
        Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

// Wait for the query to complete.
        queryJob = queryJob.waitFor();

// Check for errors
        if (queryJob == null) {
            throw new RuntimeException("Job no longer exists");
        } else if (queryJob.getStatus().getError() != null) {
            // You can also look at queryJob.getStatus().getExecutionErrors() for all
            // errors, not just the latest one.
            throw new RuntimeException(queryJob.getStatus().getError().toString());
        }
        return queryJob;
    }

}


