package com.biggerThanGreater.willy.rhymer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class instruct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruct2);

        TextView text1 = (TextView) findViewById(R.id.imageView2);
        TextView text2 = (TextView) findViewById(R.id.imageView4);
        TextView text3 = (TextView) findViewById(R.id.imageView5);
        TextView text4 = (TextView) findViewById(R.id.imageView6);
        TextView text5 = (TextView) findViewById(R.id.imageView7);
        TextView text6 = (TextView) findViewById(R.id.imageView8);
        TextView text7 = (TextView) findViewById(R.id.imageView9);
        TextView text8 = (TextView) findViewById(R.id.imageView10);
        TextView text9 = (TextView) findViewById(R.id.imageView11);
        TextView text10 = (TextView) findViewById(R.id.imageView12);
        TextView text11 = (TextView) findViewById(R.id.imageView13);


        text1.setText(" 서치라임은 사용자가 입력한 단어 혹은 자모음의 같은 초성 / 중성 / 종성 구조를 가지는 단어를 검색해주는 어플리케이션입니다. " +
                "\n\n" +
                "검색에 앞서 알아두시면 좋을 입력 제한사항은 이하 서술하는 3가지 입니다." +
                "\n\n" +
                "  - 자모음 및 글자 최소 1개이상 최대 5개이하" +
                "\n  - 한글 이외의 언어 입력 미지원" +
                "\n  - ㄺ,ㅄ,ㄳ 등 특수종성 단독입력 미지원");

        text2.setText(" 서치라임은 초성 / 중성 / 종성 으로 구성된 " +
                "\n" +
                "3가지 옵션을 가지고 있습니다." +
                "\n\n" +
                " 세 종류의 옵션은 한가지만 선택을 해야" +
                "\n" +
                "하는것이 아닌 찾기 원하는 단어의 유형에 따라" +
                "\n" +
                "다르게 조합하여 운용할 수 있습니다." +
                "\n\n" +
                " 이론적으로 8가지 경우의 조합이 나올 수 있으며 서치라임은 해당 8가지를 모두 지원합니다." +
                "\n\n");

        text3.setText("XXX , 초XX , X중X , XX종" +
                "\n" +
                "초중X , 초X종 , X중종 , 초중종" +
                "\n\n");

        text4.setText("※ XXX 옵션. 즉, 아무것도 선택하지 않은 옵션조합의 경우는 초성만 옵션으로 선택한 경우와 동일하게 작동됩니다.");

        text5.setText("기본 사용 예시");

        text6.setText("기리보이 + 초성\n=\n" +
                "자음 ㄱㄹㅂㅇ 가 순서대로\n" +
                "배치되어있는 모든 단어검색" +
                "\n\n" +
                "라이노 + 중성 \n=\n" +
                "중성 ㅏㅣㅗ 가 순서대로\n" +
                "배치되어있는 모든 단어검색" +
                "\n\n" +
                "킬라그램 + 종성\n=\n" +
                "종성 ㄹ X X ㅁ 가 순서대로\n" +
                "배치되어있는 모든 단어검색\n");

        text7.setText("※ 종성옵션의 경우 받침이 없는 글자도 종성으로 인식되어 검색되니 참고하여 주시길 바랍니다.\n\n");

        text8.setText("응용 사용 예시");

        text9.setText("ㄱㅈ적 + 초성/중성/종성\n=\n" +
                "'적'이란 글자가 마지막에 오며 앞 글자에 초성 ㄱㅈ 가 순서대로 배치되어 있는 모든 단어검색" +
                "\n\n" +
                "ㅘㅗ적 + 초성/중성/종성\n=\n" +
                "'적'이라는 글자가 마지막에 오며 앞 글자에 중성 ㅘㅗ가 순서대로 배치되어 있는 모든 단어검색" +
                "\n\n" +
                "자동 + 초성/중성\n=\n" +
                "초성 및 중성으로 자,도 가 순서대로 배치되어 있고 종성이 다른 모든 단어검색\n\n");

        text10.setText("※ '적'을 앞으로 배치해도 무방\n\n" +
                "※ 종성옵션의 경우 받침이 없는 글자도 종성으로 인식되어 검색되니 참고하여 주시길 바랍니다.\n\n\n");

        text11.setText("참고사항\n\n" +
                "※ 검색결과는 한번 검색에 최대 2000개 까지 출력할 수 있으므로 넓은 범위의 단어를 검색할 경우 결과가 제한될 수 있습니다.\n" +
                "모든 검색결과를 확인하기 위해서는 데이터를 좀더 넣어 검색범위를 좁혀주시기 바랍니다\n\n" +
                "※ 초성옵션을 선택하였을때, ㅗ,ㅏ,ㅡ,ㅣ 등과 같이 중성만 단독으로 입력하였을 경우 검색데이터에 반영되지 않은채로 검색되오니 참고하여 주시기 바랍니다.\n\n" +
                "※ 초성과 종성 옵션을 같이 선택한 이후, ㄱㄹㄴ 등과 같이 초성이면서 동시에 종성도 될 수 있는 값이 입력되었을 경우 종성 옵션보다 초성 옵션이 우선적으로 적용됩니다.\n\n" +
                "※ 버그리포팅, 개선사항, 혹은 건의사항이 있으실 경우 parkhyongsok@naver.com 으로 메일을 보내주신다면 감사히 검토해보도록 하겠습니다.\n\n" +
                "서치라임을 다운받고 이용해주셔서 정말 감사합니다\n" +
                "다운로드와 평점, 건의사항은 개발자의 힘이 됩니다");
    }
}
