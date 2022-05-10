package project6_2.cookandroid.com.dadjokegameproject;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Vector;

import static android.media.CamcorderProfile.get;

public class level1 extends AppCompatActivity {
    Vector<Integer> level1 = new Vector<>();
    Vector<String> answers = new Vector<>();
    Vector<String> comments = new Vector<>();
    int count;
    Random random = new Random();

    ImageView imageView;
    EditText edittext;
    Button checkbutton;
    TextView comment;
    int randomNum;
    boolean isFalse = false;
    String explain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        level1.add(R.drawable.bananakick);
        level1.add(R.drawable.cartok);
        level1.add(R.drawable.cowup);
        level1.add(R.drawable.redroadcoin);
        level1.add(R.drawable.washingturn);

        answers.add("바나나킥");
        answers.add("카톡");
        answers.add("소오름");
        answers.add("홍길동전");
        answers.add("워싱턴");

        comments.add("바나나가 웃으면?");
        comments.add("자동차를 톡 치면?");
        comments.add("소가 계단을 오르면?");
        comments.add("붉은 길 위에 동전이 떨어져있으면?");
        comments.add("턴이 씻고있으면?");

        imageView = (ImageView) findViewById(R.id.imageView);
        edittext = (EditText) findViewById(R.id.edittext);
        checkbutton = (Button) findViewById(R.id.checkbutton);
        comment = (TextView) findViewById(R.id.comment);

        randomNum = random.nextInt(level1.size());
        int fileName = level1.get(randomNum);
        explain = comments.get(randomNum);
        imageView.setImageResource(fileName);
        comment.setText(explain);


        checkbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String answer = edittext.getText().toString();

                for (int i = 0; i < level1.size(); i++) {
                    if (randomNum == i) {

                        if (answer.equals(answers.get(i))) { // 맞은 경우
                            if (!isFalse) {
                                count++;
                            }
                            level1.remove(i);
                            answers.remove(i);
                            comments.remove(i);
                            if (answers.size() == 0) { // 다 맞췄을 때
                                dialog();
                            } else {
                                Toast.makeText(level1.this, "정답입니다", Toast.LENGTH_SHORT).show();
                                getRandomImage();
                            }

                        } else { // 틀린 경우
                            Toast.makeText(level1.this, "오답입니다,다시 한 번 생각해보세요.", Toast.LENGTH_SHORT).show();
                            isFalse = true;
                        }
                        break;
                    }
                }


            }
        });

    }

    public void getRandomImage() {
        randomNum = random.nextInt(level1.size());
        int fileName = level1.get(randomNum);
        explain = comments.get(randomNum);
        imageView.setImageResource(fileName);
        comment.setText(explain);
        edittext.setText("");
        isFalse = false;
    }

    public void dialog() {
        AlertDialog.Builder dlg = new AlertDialog.Builder(level1.this);

        String message;
        if (count < 3) { // 0,1,2
            message = "아, 연습좀 하셔야겠네요";
        } else if (count < 5) { // 3,4
            message = "오우 아재개그에 소질있으신데요!";
        } else {
            message = "당신은 혹시 50대?";

        }

        dlg.setMessage(message);
        dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        dlg.show();
    }
}

