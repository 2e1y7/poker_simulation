package Poker;

import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class poker extends Frame implements ActionListener {
    /**
     *
     */
    private static final long serialVersionUID = 9036424656572605471L;
    // 表示ウィンドウサイズ
    private static final int WIDTH = 500;
    private static final int HEIGHT = 300;

    // 描画領域の余白
    // private static final int LEFT_MARGIN = 100;
    // private static final int RIGHT_MARGIN = 100;
    // private static final int TOP_MARGIN = 150; // ボタン配置のための余裕
    // private static final int BOTTOM_MARGIN = 50;
    // private static final int NET_WIDTH = WIDTH - LEFT_MARGIN - RIGHT_MARGIN;
    // private static final int NET_HEIGHT = HEIGHT - TOP_MARGIN - BOTTOM_MARGIN;
    
    private Player[] player;
    private Dealer dealer;
    private boolean[][] cards;
    private float rate;
    
    private Choice choicePlayer;
    private Choice choiceSomeone;
    private Choice choiceSuit1;
    private Choice choiceSuit2;
    private Choice choiceSuit3;
    private Choice choiceNumber1;
    private Choice choiceNumber2;
    private Choice choiceNumber3;
    
    private Label messageLabel;

    public poker() {

        // set window size
        setSize(WIDTH, HEIGHT);

        // definition of layout
        setLayout(new FlowLayout());
        // プレイヤ―数(ディーラー含む)
        Label label1 = new Label("How many Prayer?");
        add(label1);
        choicePlayer = new Choice();
        choicePlayer.addItem("2");
        choicePlayer.addItem("3");
        choicePlayer.addItem("4");
        add(choicePlayer);

        // プレイヤー数の決定
        Button decidePlayer = new Button("Decide");
        add(decidePlayer);
        decidePlayer.addActionListener(this);

        // 誰のカード？
        // player1をユーザーとして考える。
        Label label3 = new Label("who's card?");
        add(label3);
        choiceSomeone = new Choice();
        choiceSomeone.addItem("dealer");
        choiceSomeone.addItem("player1");
        choiceSomeone.addItem("player2");
        choiceSomeone.addItem("player3");
        add(choiceSomeone);

        // カード情報の設定
        Label label2 = new Label("set cards");
        add(label2);
        choiceSuit1 = new Choice();
        choiceSuit1.addItem("Spade");
        choiceSuit1.addItem("Heart");
        choiceSuit1.addItem("Diamond");
        choiceSuit1.addItem("Club");
        add(choiceSuit1);

        choiceNumber1 = new Choice();
        choiceNumber1.addItem("A");
        choiceNumber1.addItem("2");
        choiceNumber1.addItem("3");
        choiceNumber1.addItem("4");
        choiceNumber1.addItem("5");
        choiceNumber1.addItem("6");
        choiceNumber1.addItem("7");
        choiceNumber1.addItem("8");
        choiceNumber1.addItem("9");
        choiceNumber1.addItem("10");
        choiceNumber1.addItem("J");
        choiceNumber1.addItem("Q");
        choiceNumber1.addItem("K");
        add(choiceNumber1);

        choiceSuit2 = new Choice();
        choiceSuit2.addItem("Spade");
        choiceSuit2.addItem("Heart");
        choiceSuit2.addItem("Diamond");
        choiceSuit2.addItem("Club");
        add(choiceSuit2);

        choiceNumber2 = new Choice();
        choiceNumber2.addItem("A");
        choiceNumber2.addItem("2");
        choiceNumber2.addItem("3");
        choiceNumber2.addItem("4");
        choiceNumber2.addItem("5");
        choiceNumber2.addItem("6");
        choiceNumber2.addItem("7");
        choiceNumber2.addItem("8");
        choiceNumber2.addItem("9");
        choiceNumber2.addItem("10");
        choiceNumber2.addItem("J");
        choiceNumber2.addItem("Q");
        choiceNumber2.addItem("K");
        add(choiceNumber2);

        choiceSuit3 = new Choice();
        // choiceSuit3.addItem("NULL");
        choiceSuit3.addItem("Spade");
        choiceSuit3.addItem("Heart");
        choiceSuit3.addItem("Diamond");
        choiceSuit3.addItem("Club");
        add(choiceSuit3);

        choiceNumber3 = new Choice();
        // choiceNumber3.addItem("NULL");
        choiceNumber3.addItem("A");
        choiceNumber3.addItem("2");
        choiceNumber3.addItem("3");
        choiceNumber3.addItem("4");
        choiceNumber3.addItem("5");
        choiceNumber3.addItem("6");
        choiceNumber3.addItem("7");
        choiceNumber3.addItem("8");
        choiceNumber3.addItem("9");
        choiceNumber3.addItem("10");
        choiceNumber3.addItem("J");
        choiceNumber3.addItem("Q");
        choiceNumber3.addItem("K");
        add(choiceNumber3);

        // カードを決める
        Button setcardButton = new Button("set");
        add(setcardButton);
        setcardButton.addActionListener(this);

        // 実行
        Button doneButton = new Button("done");
        add(doneButton);
        doneButton.addActionListener(this);

        // クリア
        Button clearButton = new Button("clear");
        add(clearButton);
        clearButton.addActionListener(this);

        // 終了
        Button exitButton = new Button("exit");
        add(exitButton);
        exitButton.addActionListener(this);

        messageLabel = new Label("show message");
        add(messageLabel);

        setVisible(true);
        rate = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String commandName = e.getActionCommand();
        if (commandName.equals("Decide")) {
            // System.out.println("!");
            init();
        } else if (commandName.equals("set")) {
            //set(choiceSomeone.getSelectedItem());
            setSample();
        } else if (commandName.equals("done")) {
            calculate();
        } else if (commandName.equals("clear")) {

        } else if (commandName.equals("exit")) {
            System.exit(0);
        }
        repaint();
    }

    private void init() {
        cards = new boolean[4][13];
        // player = new Player[Integer.parseInt(choicePlayer.getSelectedItem())];
        player = new Player[2];
        dealer = new Dealer();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cards[i][j] = false;
            }
        }

        for (int i = 0; i < player.length; i++) {
            player[i] = new Player();
            for (int j = 0; j < 2; j++) {
                player[i].suit[i] = -1;
                player[i].num[i] = -1;
            }

        }

        for (int i = 2; i < 5; i++) {
            // 初期値を決定する
            dealer.suit[i] = -1;
            dealer.num[i] = -1;
        }

        messageLabel.setText("initialized");
    }

    private void set(String name) {
        if (name == "dealer") {
            // System.out.println("!!");
            dealer.setCard();
            dealer.showInfo();
        } else {
            player[choiceSomeone.getSelectedIndex() - 1].setCard();
            player[choiceSomeone.getSelectedIndex() - 1].showInfo();
        }
        System.out.println("set " + name + "'s cards");
        messageLabel.setText("set" + name + "'s cards");

    }

    private void setSample() {
        dealer.num[0] =3;
        dealer.num[1] = 2;
        dealer.num[2] = 1;
        dealer.num[3] = -1;
        dealer.num[4] = -1;
        dealer.suit[0] = 3;
        dealer.suit[1] = 3;
        dealer.suit[2] = 3;
        dealer.suit[3] = -1;
        dealer.suit[4] = -1;
        player[0].num[0] = 4;
        player[0].num[1] = 5;
        player[0].suit[0] = 3;
        player[0].suit[1] = 3;
        player[1].num[0] = 9;
        player[1].num[1] = 5;
        player[1].suit[0] = 3;
        player[1].suit[1] = 1;
        showAll();
    }

    private void calculate() {
        Integer rank[] = new Integer[player.length];

        //プレイヤーのhandの評価
        for (int i = 0; i < player.length; i++) {
            isOnePair(player[i]);
            isTwoPair(player[i]);
            isThreeCard(player[i]);
            isStraight(player[i]);
            isFlash(player[i]);
            isFullHouse(player[i]);
            isFourCard(player[i]);
            isStraightFlash(player[i]);
            System.out.println("player[" + i + "]'s hand is " + player[i].hand);
            rank[i] = player[i].hand;
        }

        Arrays.sort(rank, Collections.reverseOrder());

        for (int i = 1; i < player.length; i++) {
            /**
             * player[0]が持っているハンドよりもつよいハンドの確率を計算する。
             */
            if (player[0].hand >= player[i].hand) {
                if (player[0].hand <= 1) {
                    rate =+ rateOnePair(player[i], player[0]);
                } else if (player[0].hand <= 2) {
                    rate =+ rateTwoPair(player[i], player[0]);
                } else if (player[0].hand <= 3) {
                    rate =+ rateThreeCard(player[i], player[0]);
                } else if (player[0].hand <= 4) {
                    rate =+ rateStraight(player[i], player[0]);
                } else if (player[0].hand <= 5) {
                    rate =+ rateFlash(player[i], player[0]);
                } else if (player[0].hand <= 6) {
                    rate =+ rateFullHouse(player[i], player[0]);
                } else if (player[0].hand <= 7) {
                    rate =+ rateFourCard(player[i], player[0]);
                } else if (player[0].hand <= 8) {
                    rate =+ rateStraightFlash(player[i], player[0]);
                }
            } else {
                if (player[i].hand <= 1) {
                    rate =+ rateOnePair(player[0], player[i]);
                } else if (player[i].hand <= 2) {
                    rate =+ rateTwoPair(player[0], player[i]);
                } else if (player[i].hand <= 3) {
                    rate =+ rateThreeCard(player[0], player[i]);
                } else if (player[i].hand <= 4) {
                    rate =+ rateStraight(player[0], player[i]);
                } else if (player[i].hand <= 5) {
                    rate =+ rateFlash(player[0], player[i]);
                } else if (player[i].hand <= 6) {
                    rate =+ rateFullHouse(player[0], player[i]);
                } else if (player[i].hand <= 7) {
                    rate =+ rateFourCard(player[0], player[i]);
                } else if (player[i].hand <= 8) {
                    rate =+ rateStraightFlash(player[0], player[i]);
                }
            }
        }

        showAll();
    }
    
    //xがyに勝つ確率
    private float rateOnePair(Player x, Player y) {
        //確率
        float rate = 0;
        //枚数
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 13; k++) {
                if (!cards[i][k]) {
                    count++;
                }
            }
        }
        //役が同じだった場合
        if (y.hand == x.hand) {
            //場でワンペアだった場合
            if (x.handNum == y.handNum) {
                return 2 * (6 / count);
            }
            //ハンド内でどちらもそろっていた時
            if (x.num[1] == x.num[0] || y.num[0] == y.num[1]) {
                //ex)[0]={Dia2,club2}, [1]={heart2,spade2}
                //またはyのほうが数字が大きい
                if (x.num[0] <= y.num[0]) {
                    return 0;
                } else if (x.num[1] > y.num[1]) {
                    return 1;
                }
                return 0;
            }
        }

        for (int i = 0; i < 2; i++) {
            if(x.num[i] > y.handNum){
                rate =+ 2 * (3 / count);
            }
        }
        return rate;
    }

    private float rateTwoPair(Player x, Player y) {
        // 枚数
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 13; k++) {
                if (!cards[i][k]) {
                    count++;
                }
            }
        }

        //同じ強さの場合
        if (x.hand == y.hand) {
            if (x.handNum > y.handNum) {
                return 1;
            } else {
                //同じ役で数字もこちらが弱い場合はフルハウスにしなければならないので
                return 2 * (4 / count);
            }
        }
        
        if (x.hand != 1) {
            //ブタからスリーカードを狙いに行く人
            return (3 / count) * (2 / count - 1) * 2;
        } else {
            //ワンペアから狙いにいく人
            return 2 * (4 / count);
        }
    }

    private float rateThreeCard(Player x, Player y) {
        // 枚数
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 13; k++) {
                if (!cards[i][k]) {
                    count++;
                }
            }
        }

        if (x.hand == y.hand) {
            if (x.handNum > y.handNum) {
                return 1;
            } else if (x.handNum == y.handNum) {
                return 0;
            } else if (x.handNum < y.handNum) {
                return 2 * (1 / count);
            }
        }
        
        if (isOnePair(x)) {
            if (x.handNum > y.handNum) {
                return 2 * (2 / count);
            } else {
                return 0;
            }
        }
        
        if (isTwoPair(x)) {
            return 2 * (4 / count);
        }
        
        return 0;
    }

    private float rateStraight(Player x, Player y) {
        if (x.hand == y.hand) {
            if (x.handNum > y.handNum) {
                return 1;
            } else {
                return 0;
            }
        }
        //条件がかなり難しい上確率的に相当低いと考えられるため考慮しない事とする
        return 0;
    }

    private float rateFlash(Player x, Player y) {
        if (x.hand == y.hand) {
            if (x.handNum > y.handNum) {
                return 1;
            } else {
                return 0;
            }
        }
        return 0;
    }

    private float rateFullHouse(Player x, Player y) {
        if (x.hand == y.hand) {
            if (x.handNum > y.handNum) {
                return 1;
            } else {
                return 0;
            }
        }
        return 0;
    }

    private float rateFourCard(Player x, Player y) {
        if (x.hand == y.hand) {
            if (x.handNum > y.handNum) {
                return 1;
            } else {
                return 0;
            }
        }
        return 0;
    }

    private float rateStraightFlash(Player x, Player y) {
        if (x.hand == y.hand) {
            if (x.handNum > y.handNum) {
                return 1;
            } else {
                return 0;
            }
        }
        return 0;
    }

    /**
     * ここから下はペアがあるかどうかの判定 あればtrueを返すように設計 ストリームと同じ要領で呼び出しを行う ワンペア ツーペア スリーカード
     * ・・・って感じ ある程度の前提を伴ったコードになっている。
     */

    private boolean isOnePair(Player x) {
        // ハンド内での役完成のパターン ok
        if (x.num[0] == x.num[1]) {
            x.hand = 1;
            return true;
        }

        // 場と手札内で役完成のパターン ok
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                if (x.num[j] == dealer.num[i]) {
                    x.hand = 1;
                    x.handNum = x.num[j];
                    return true;
                }
                // 場にこれ以上組み合わせるカードがないときの処理
                else if (dealer.suit[i] == -1 || dealer.num[i] == -1) {
                    return false;
                }
            }
        }

        // dealerのハンド内(場)で役完成のパターン ok
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (dealer.num[i] == dealer.num[j] && dealer.num[j] != -1) {
                    x.hand = 1;
                    x.handNum = dealer.num[i];
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isTwoPair(Player x) {
        // 前提条件
        if (!isOnePair(x)) {
            return false;
        }
        // 手札でワンペア、場でワンペアのパターン ok
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (x.num[0] == x.num[1] && dealer.num[i] == dealer.num[j] && dealer.num[j] != -1) {
                    if (x.num[0] < dealer.num[i]) {
                        x.handNum = dealer.num[i];
                    } else {
                        x.handNum = x.num[i];
                    }
                    x.hand = 2;
                    return true;
                }
            }
        }

        // 場と手札内で役完成のパターン ok
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                // 場と手札で同じ数字があってかつその数字が既知のものとは違う場合
                if (x.num[j] == dealer.num[i] && x.num[j] != x.handNum) {
                    if (x.num[j] > x.handNum) {
                        x.handNum = x.num[j];
                    }
                    x.hand = 2;
                    return true;
                }
                // 場にこれ以上組み合わせるカードがないときの処理
                else if (dealer.suit[i] == -1 || dealer.num[i] == -1) {
                    return false;
                }
            }
        }
        return false;
    }

    private boolean isThreeCard(Player x) {
        if (!isOnePair(x)) {
            return false;
        }

        // 手札に二枚、場に一枚あるパターン ok
        if (x.num[0] == x.num[1]) {
            for (int i = 0; i < 5; i++) {
                if (dealer.num[i] == -1) {
                    break;
                } else if (x.num[0] == dealer.num[i]) {
                    x.hand = 3;
                    x.handNum = x.num[0];
                    return true;
                }
            }
        }

        // 手札に一枚、場に二枚あるパターン ok
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (dealer.num[j] == -1) {
                    break;
                }
                if (dealer.num[i] == dealer.num[j]) {
                    if (dealer.num[i] == x.num[0] || dealer.num[i] == x.num[1]) {
                        x.hand = 3;
                        x.handNum = dealer.num[i];
                        return true;
                    }
                }
            }
        }
        // 場に三枚あるパターン ok
        if (dealer.num[1] == dealer.num[2] && dealer.num[0] == dealer.num[2]) {
            x.hand = 3;
            x.handNum = dealer.num[1];
            return true;
        }
        return false;
    }

    private boolean isStraight(Player x) {
        //ok
        Integer temp[] = new Integer[7];
        int count = 0;
        for (int i = 0; i < 7; i++) {
            if (i < 5) {
                temp[i] = dealer.num[i];
            } else {
                temp[i] = x.num[i - 5];
            }
        }

        Arrays.sort(temp, Collections.reverseOrder());

        int a = temp[0];
        for (int i = 1; i < 4; i++) {
            if (temp[i] == -1) {
                break;
            }
            if (a - 1 == temp[i]) {
                int j = i;
                while (a - 1 == temp[j]) {
                    if (count == 5) {
                        // straight
                        x.hand = 4;
                        x.handNum = temp[j];
                        return true;
                    }
                    a = temp[j];
                    count++;
                    j++;
                }
            }
            a = temp[i];
        }

        return false;
    }

    private boolean isFlash(Player x) {
        Integer temp[] = new Integer[7];
        int count = 0;
        for (int i = 0; i < 7; i++) {
            if (i < 5) {
                temp[i] = dealer.suit[i];
            } else {
                temp[i] = x.suit[i - 5];
            }
        }

        Arrays.sort(temp, Collections.reverseOrder());
        int a = temp[0];
        for (int i = 1; i < 4; i++) {
            if (a == temp[i]) {
                int j = i;
                while (a == temp[j]) {
                    count++;
                    j++;
                    if (count == 5) {
                        // It's Flash!!!!!
                        x.hand = 5;
                        x.handNum = temp[j];
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isFullHouse(Player x) {
        //手札にワンペアで場に3カード
        if (x.num[0] == x.num[1]) {
            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 4; j++) {
                    for (int k = j + 1; k < 5; k++) {
                        if (dealer.num[i] == dealer.num[j] && dealer.num[k] == dealer.num[j]) {
                            x.hand = 6;
                            x.handNum = dealer.num[k];
                            return true;
                        }
                    }
                }
            }

            //手札と場を組み合わせてスリーカード、場でワンペア
            for (int i = 0; i < 5; i++) {
                if (x.num[1] == dealer.num[i]) {
                    for (int j = 0; j < 4; j++) {
                        for (int k = j + 1; k < 5; k++) {
                            if (dealer.num[j] == dealer.num[k]) {
                                x.hand = 6;
                                x.handNum = x.num[1];
                                return true;
                            }
                        }
                    }
                }
            }
        }
        
        //組み合わせてふるハウス
        if (isThreeCard(x)) {
            int handNum = x.handNum;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 5; j++) {
                    if ((x.num[i] == dealer.num[j]) && x.num[i] != handNum) {
                        x.hand = 6;
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean isFourCard(Player x) {
        Integer temp[] = new Integer[7];
        int count = 0;
        for (int i = 0; i < 7; i++) {
            if (i < 5) {
                temp[i] = dealer.num[i];
            } else {
                temp[i] = x.num[i - 5];
            }
        }

        Arrays.sort(temp, Collections.reverseOrder());

        int a = temp[0];
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] == -1) {
                return false;
            }
            if (a == temp[i]) {
                int j = i;
                while (a == temp[j]) {
                    count++;
                    j++;
                    if (count == 4) {
                        // It's Four Cards!!!!!
                        x.hand = 7;
                        x.handNum = temp[j];
                        return true;
                    }
                }
            }
            a = temp[i];
        }
        return false;
    }

    private boolean isStraightFlash(Player x) {
        if (isFlash(x) && isStraight(x)) {
            /**
             * フルハウスの判定機と同様の理由により、書き換えない。 ロイヤルストレートフラッシュは考えないことにした。
             */
            x.hand = 8;
        }
        return true;
    }

    private void showAll() {
        for (int i = 0; i < player.length; i++) {
            System.out.print("player[" + i + "] : ");
            player[i].showInfo();
        }
        System.out.print("dealer : ");
        
        if (rate != 0) {
            System.out.println("You have about " + rate*100 + "% chance of winning.");
        }
        dealer.showInfo();
    }

    class Player {
        String playerName;
        int[] suit;
        int[] num;
        // 役の強さ(何の役か)
        int hand;
        // 役の数字
        int handNum;

        public Player() {
            hand = 0;
            handNum = 0;
            this.suit = new int[2];
            this.num = new int[2];
        }

        void setCard() {
            playerName = choiceSomeone.getSelectedItem();
            int suit1 = choiceSuit1.getSelectedIndex();
            int suit2 = choiceSuit2.getSelectedIndex();
            int num1 = choiceNumber1.getSelectedIndex();
            int num2 = choiceNumber2.getSelectedIndex();

            if (isDoubled(suit1, num1)) {
                // 数字の帳尻を合わせるための++;
                cards[suit1][num1] = true;
                this.suit[0] = suit1;
                this.num[0] = num1 + 1;
            } else {
                System.out.println("doubled");
                return;
            }

            if (isDoubled(suit2, num2)) {
                cards[suit2][num2] = true;
                this.suit[1] = suit2;
                this.num[1] = num2 + 1;
            } else {
                System.out.println("doubled");
                return;
            }
        }

        void showInfo() {
            for (int i = 0; i < this.num.length; i++) {
                String name = "none";
                if (this.suit[i] == 0) {
                    name = "Spade";
                } else if (this.suit[i] == 1) {
                    name = "Heart";
                } else if (this.suit[i] == 2) {
                    name = "Diamond";
                } else if (this.suit[i] == 3) {
                    name = "Club";
                }
                System.out.print(name + this.num[i] + ", ");
            }
            System.out.println();
        }

        boolean isDoubled(int suit, int num) {
            // ダブってたらfalse
            return !cards[suit][num];
        }

    }

    class Dealer extends Player {
        // 枚数を保持
        int count;

        public Dealer() {
            // hand = 0;
            // handNum = 0;
            this.suit = new int[5];
            this.num = new int[5];
            for (int i = 0; i < 5; i++) {
                // 初期値を決定する
                this.suit[i] = -1;
                this.num[i] = -1;
                //System.out.println(this.suit[i]);
            }
        }

        @Override
        void setCard() {
            super.setCard();

            int suit3 = choiceSuit3.getSelectedIndex();
            int num3 = choiceNumber3.getSelectedIndex();
            if (isDoubled(suit3, num3)) {
                cards[suit3][num3] = true;
                suit[2] = suit3;
                num[2] = num3 + 1;
            } else {
                System.out.println("doubled");
                return;
            }
            count = 3;
        }

    }

    public static void main(String[] args) {
        new poker();
    }

}