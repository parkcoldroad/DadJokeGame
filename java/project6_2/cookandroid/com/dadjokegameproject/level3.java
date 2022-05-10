package project6_2.cookandroid.com.dadjokegameproject;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Vector;

public class level3 extends AppCompatActivity {

    Vector<Integer> level3 = new Vector<>();
    Vector<String> answers = new Vector<>();
    Vector<String> comments = new Vector<>();
    int count;
    Random random = new Random();

    ImageView imageView;
    EditText edittext;
    Button checkbutton;
    TextView comment;
    String explain;

    int randomNum;
    boolean isFalse = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);

        level3.add(R.drawable.brocalllee);
        level3.add(R.drawable.coldroad);
        level3.add(R.drawable.ganada);
        level3.add(R.drawable.lefttemple);
        level3.add(R.drawable.threedirfference);

        answers.add("브로콜리");
        answers.add("찬길");
        answers.add("가나다");
        answers.add("좌절");
        answers.add("세대차이");

        comments.add("한 남자가 다른 남자에게 이 씨를 불러달라고 하면?");
        comments.add("길이 차가우면?");
        comments.add("세종대왕이 가장 좋아하는 초콜릿은?");
        comments.add("왼쪽으로 절을하면?");
        comments.add("나는 1대 상대는 4대 때리면?");

        imageView = (ImageView) findViewById(R.id.imageView);
        edittext = (EditText) findViewById(R.id.edittext);
        checkbutton = (Button) findViewById(R.id.checkbutton);
        comment=(TextView)findViewById(R.id.comment);

        randomNum = random.nextInt(level3.size());
        int fileName = level3.get(randomNum);
        explain = comments.get(randomNum);
        imageView.setImageResource(fileName);
        comment.setText(explain);

        checkbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String answer = edittext.getText().toString();

                for (int i = 0; i < level3.size(); i++) {
                    if (randomNum == i) {
                        if (answer.equals(answers.get(i))) { // 맞은 경우
                            if (!isFalse) {
                                count++;
                            }
                            level3.remove(i);
                            answers.remove(i);
                            comments.remove(i);
                            if (answers.size() == 0) { // 다 맞췄을 때
                                dialog();
                            } else {
                                Toast.makeText(level3.this, "정답입니다", Toast.LENGTH_SHORT).show();
                                getRandomImage();
                            }

                        } else { // 틀린 경우
                            Toast.makeText(level3.this, "오답입니다,다시 한 번 생각해보세요.", Toast.LENGTH_SHORT).show();
                            isFalse = true;
                        }
                        break;
                    }
                }


            }
        });

    }

    public void getRandomImage() {
        randomNum = random.nextInt(level3.size());
        int fileName = level3.get(randomNum);
        explain = comments.get(randomNum);
        imageView.setImageResource(fileName);
        comment.setText(explain);
        edittext.setText("");
        isFalse = false;
    }

    public void dialog() {
        AlertDialog.Builder dlg = new AlertDialog.Builder(level3.this);

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


