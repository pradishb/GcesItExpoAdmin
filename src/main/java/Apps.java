
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.tasks.Task;
import com.google.firebase.tasks.Tasks;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class Apps {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args){
        System.out.println(new Apps().getGreeting());

        try {
            FileInputStream serviceAccount = new FileInputStream("gcesitexpo-firebase-adminsdk-61f7n-c33a170f7c.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://gcesitexpo.firebaseio.com/")
                    .build();

            FirebaseApp.initializeApp(options);

            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference("sdf");

            Task<Void> task = ref.setValue("sffffdf");
            try {
                Tasks.await(task);
            } catch (ExecutionException | InterruptedException e) {
                // Handle error if necessary
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

//        ValueEventListener postListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // Get Post object and use the values to update the UI
//                String post = dataSnapshot.getValue(String.class);
//                System.out.println(post);
//                // ...
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                // Getting Post failed, log a messag
//                // ...
//            }
//        };
//        myRef.addValueEventListener(postListener);

    }
}