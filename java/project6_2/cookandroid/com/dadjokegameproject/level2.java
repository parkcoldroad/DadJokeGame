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

public class level2 extends AppCompatActivity {
    Vector<Integer> level2 = new Vector<>();
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
        setContentView(R.layout.activity_level2);

        level2.add(R.drawable.badminton);
        level2.add(R.drawable.deadsalt);
        level2.add(R.drawable.fourfire);
        level2.add(R.drawable.onebean);
        level2.add(R.drawable.samsumgfire);

        answers.add("배드민턴");
        answers.add("죽염");
        answers.add("사파이어");
        answers.add("원빈");
        answers.add("삼성화재");

        comments.add("턴이 침대를 밀면?");
        comments.add("소금이 죽어버리면?");
        comments.add("불이 4개있으면?");
        comments.add("(잘생긴) 콩 하나?");
        comments.add("성 3개가 불에 타고 있으면?");

        imageView = (ImageView) findViewById(R.id.imageView);
        edittext = (EditText) findViewById(R.id.edittext);
        checkbutton = (Button) findViewById(R.id.checkbutton);
        comment=(TextView)findViewById(R.id.comment);

        randomNum = random.nextInt(level2.size());
        int fileName = level2.get(randomNum);
        explain = comments.get(randomNum);
        imageView.setImageResource(fileName);
        comment.setText(explain);


        checkbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String answer = edittext.getText().toString();

                for (int i = 0; i < level2.size(); i++) {
                    if (randomNum == i) {
                        if (answer.equals(answers.get(i))) { // 맞은 경우
                            if (!isFalse) {
                                count++;
                            }
                            level2.remove(i);
                            answers.remove(i);
                            comments.remove(i);
                            if (answers.size() == 0) { // 다 맞췄을 때
                                dialog();
                            } else {
                                Toast.makeText(level2.this, "정답입니다", Toast.LENGTH_SHORT).show();
                                getRandomImage();
                            }

                        } else { // 틀린 경우
                            Toast.makeText(level2.this, "오답입니다,다시 한 번 생각해보세요.", Toast.LENGTH_SHORT).show();
                            isFalse = true;
                        }
                        break;
                    }
                }


            }
        });

    }

    public void getRandomImage() {
        randomNum = random.nextInt(level2.size());
        int fileName = level2.get(randomNum);
        explain = comments.get(randomNum);
        imageView.setImageResource(fileName);
        comment.setText(explain);
        edittext.setText("");
        isFalse = false;
    }

    public void dialog() {
        AlertDialog.Builder dlg = new AlertDialog.Builder(level2.this);

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

