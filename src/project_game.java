import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class project_game extends JFrame {
    public static void main (String[] args){
        new project_game().show();
    }
    JLabel triedLabel = new JLabel();
    JTextField triedTextF=new JTextField();
    JLabel correctLabel=new JLabel();
    JTextField correctTextF=new JTextField();
    JTextField podskazTextF=new JTextField();
    JLabel uncorrectLabel=new JLabel();
    JTextField uncorrectTextF=new JTextField();
    JLabel problemLabel = new JLabel();
    JLabel dividerLabel=new JLabel();
    Font myFont=new Font("Arial",Font.PLAIN,16);
    Color lightBlue=new Color(192,192,255);
    JPanel factorPanel = new JPanel();
    JButton[] factorButton=new JButton[33];
    JButton startBut=new JButton();
    JButton exitBut=new JButton();
    JButton podskazkaBut=new JButton();
    JButton contBut=new JButton();
    JButton comebackBut=new JButton();
    Random myRandom = new Random();
    int numberTried, numberCorrect, numberUncorrect;
    String[] kirillArray = {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я"};
    int butSelect;
    int k1;
    List<Integer> spis= new ArrayList<Integer>();
    String[] slova={"теория","метод","иерархия","решение","диаграмма","мотивация","контроль","сравнение","множество",
            "управление","вектор","альтернатива","проект","инверсия","срок","свертка","планирование","выбор","эксперт"};
    String str;
    int pType;
    String[] ms;
    String[] chert;
    String corrStr;
    int ksl = 0;
    String str1;  int k = 0;
    String s="";

    public project_game(){
        setTitle("Я загадал слово");
        getContentPane().setBackground(new Color(255,255,192));
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitForm(e);
            }
        });
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridCons;
        triedLabel.setText("Попытки: ");
        triedLabel.setFont(myFont);
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=0;
        gridCons.anchor=GridBagConstraints.WEST;
        gridCons.insets=new Insets(10,10,0,10);
        getContentPane().add(triedLabel,gridCons);
        triedTextF.setText("0");
        triedTextF.setPreferredSize(new Dimension(90,30));
        triedTextF.setEditable(false);
        triedTextF.setBackground(Color.RED);
        triedTextF.setForeground(Color.YELLOW);
        triedTextF.setHorizontalAlignment(SwingConstants.CENTER);
        triedTextF.setFont(myFont);
        gridCons=new GridBagConstraints();
        gridCons.gridx=1;
        gridCons.gridy=0;
        gridCons.insets=new Insets(10,0,0,0);
        getContentPane().add(triedTextF,gridCons);

        correctLabel.setText("Угадано слов: ");
        correctLabel.setFont(myFont);
        gridCons=new GridBagConstraints();
        gridCons.gridx=2;
        gridCons.gridy=0;
        gridCons.anchor=GridBagConstraints.CENTER;
        gridCons.insets=new Insets(10,190,0,10);
        getContentPane().add(correctLabel,gridCons);
        correctTextF.setText("0");
        correctTextF.setPreferredSize(new Dimension(90,30));
        correctTextF.setEditable(false);
        correctTextF.setBackground(Color.RED);
        correctTextF.setForeground(Color.YELLOW);
        correctTextF.setHorizontalAlignment(SwingConstants.CENTER);
        correctTextF.setFont(myFont);
        gridCons=new GridBagConstraints();
        gridCons.gridx=3;
        gridCons.gridy=0;
        gridCons.insets=new Insets(10,0,0,120);
        getContentPane().add(correctTextF,gridCons);

        uncorrectLabel.setText("Неугадано слов: ");
        uncorrectLabel.setFont(myFont);
        gridCons=new GridBagConstraints();
        gridCons.gridx=4;
        gridCons.gridy=0;
        gridCons.anchor=GridBagConstraints.EAST;
        gridCons.insets=new Insets(10,10,0,10);
        getContentPane().add(uncorrectLabel,gridCons);
        uncorrectTextF.setText("0");
        uncorrectTextF.setPreferredSize(new Dimension(90,30));
        uncorrectTextF.setEditable(false);
        uncorrectTextF.setBackground(Color.RED);
        uncorrectTextF.setForeground(Color.YELLOW);
        uncorrectTextF.setHorizontalAlignment(SwingConstants.CENTER);
        uncorrectTextF.setFont(myFont);
        gridCons=new GridBagConstraints();
        gridCons.gridx=5;
        gridCons.gridy=0;
        gridCons.insets=new Insets(10,0,0,10);
        getContentPane().add(uncorrectTextF,gridCons);

        problemLabel.setText("");
        problemLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        problemLabel.setPreferredSize(new Dimension(600,100));
        problemLabel.setBackground(Color.WHITE);
        problemLabel.setOpaque(true);
        problemLabel.setFont(new Font("Comic Sans MS",Font.PLAIN,48));
        problemLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=1;
        gridCons.gridwidth=5;
        gridCons.insets=new Insets(20,100,0,10);
        getContentPane().add(problemLabel,gridCons);

        dividerLabel.setPreferredSize(new Dimension(420,20));
        dividerLabel.setBackground(Color.GREEN);
        dividerLabel.setOpaque(true);
        dividerLabel.setText("Слово загадано из дисциплины: Теория и методы принятия решений");
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=2;
        gridCons.gridwidth=5;
        gridCons.insets=new Insets(10,100,10,10);
        getContentPane().add(dividerLabel,gridCons);

        podskazTextF.setText("Всего 3 подсказки!");
        podskazTextF.setPreferredSize(new Dimension(150,30));
        podskazTextF.setEditable(false);
        podskazTextF.setBackground(Color.RED);
        podskazTextF.setForeground(Color.YELLOW);
        podskazTextF.setHorizontalAlignment(SwingConstants.CENTER);
        //podskazTextF.setFont(myFont);
        gridCons=new GridBagConstraints();
        gridCons.gridx=5;
        gridCons.gridy=4;
        gridCons.insets=new Insets(10,0,10,120);
        getContentPane().add(podskazTextF,gridCons);

        UIManager.put("TitleBorder.font",new Font("Arial",Font.BOLD,14));

        factorPanel.setPreferredSize(new Dimension(450,180));
        factorPanel.setBorder(BorderFactory.createTitledBorder("Алфавит:"));
        factorPanel.setBackground(lightBlue);
        factorPanel.setLayout(new GridBagLayout());
        gridCons=new GridBagConstraints();
        gridCons.gridx=2;
        gridCons.gridy=3;
        gridCons.gridwidth=2;
        gridCons.insets=new Insets(10,70,10,10);
        gridCons.anchor=GridBagConstraints.NORTH;
        getContentPane().add(factorPanel,gridCons);
        int x=0;
        int y=0;
        for (int i=0;i<=kirillArray.length-1;i++){
            String s=kirillArray[i];
            factorButton[i]=new JButton();
            factorButton[i].setText(s);
            factorButton[i].setBackground(lightBlue);
            gridCons=new GridBagConstraints();
            if (i<=32){
                gridCons.gridx=x;
                gridCons.gridy=y;
            }
            else {
                gridCons.gridx=0;
                gridCons.gridy=0;
            }
            gridCons.anchor=GridBagConstraints.WEST;
            factorPanel.add(factorButton[i],gridCons);
            factorButton[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    factorRadioButtonActionPerformed(e);
                }
            });
            x++;
            if (x>8){
                x=0; y++;
            }
        }

        startBut.setText("Начать игру");
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=4;
        gridCons.gridwidth=2;
        gridCons.insets=new Insets(10,0,5,0);
        getContentPane().add(startBut,gridCons);
        startBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButActionPerformed(e);
            }
        });
        contBut.setText("Продолжить");
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=5;
        gridCons.gridwidth=2;
        gridCons.insets=new Insets(5,0,10,0);
        getContentPane().add(contBut,gridCons);
        contBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contButActionPerformed(e);
            }
        });

        exitBut.setText("Выход");
        gridCons=new GridBagConstraints();
        gridCons.gridx=2;
        gridCons.gridy=4;
        gridCons.gridwidth=2;
        gridCons.insets=new Insets(10,0,10,0);
        getContentPane().add(exitBut,gridCons);
        exitBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitButActionPerformed(e);
            }
        });

        comebackBut.setText("Викторина");
        gridCons=new GridBagConstraints();
        gridCons.gridx=2;
        gridCons.gridy=5;
        gridCons.gridwidth=2;
        gridCons.insets=new Insets(5,0,10,0);
        getContentPane().add(comebackBut,gridCons);
        comebackBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comebackButActionPerformed(e);
            }
            private void comebackButActionPerformed(ActionEvent e) {
                new project_math_quiz().show();
            }
        });

        podskazkaBut.setText("Подсказка");
        podskazkaBut.setBackground(Color.GREEN);
        gridCons=new GridBagConstraints();
        gridCons.gridx=3;
        gridCons.gridy=4;
        gridCons.gridwidth=2;
        gridCons.insets=new Insets(10,250,10,0);
        getContentPane().add(podskazkaBut,gridCons);
        podskazkaBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                podskazkaButActionPerformed(e);
            }
        });

        pack();
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int)(0.5*(screenSize.width-getWidth())),
                (int)(0.5*(screenSize.height-getHeight())),getWidth(),
                getHeight());
    }
    private void exitForm(WindowEvent e){
        System.exit(0);
    }

    private void factorRadioButtonActionPerformed(ActionEvent e){
        if (numberTried<6){
            JButton jSelect = (JButton) e.getSource();
            System.out.println(jSelect.getText());
            for (int i = 0; i < 33; i++) {
                if (jSelect.getText()==kirillArray[i]) {
                    butSelect = i;
                    break;
                }
            }
            if (butSelect == -1) {
                return;
            }
            boolean correct = false;

            for (int j = 0; j < ms.length; j++) {
                if (jSelect.getText().toUpperCase().equals(ms[j].toUpperCase())) {
                    correct = true;
                    k1++;
                    spis.add(j);
                }
            }
            updateScore(correct);

        }else updateScore(false);


    }
    private String getProblem(String[] sl) {
        problemLabel.requestFocus();
        pType = myRandom.nextInt(slova.length);
        str = slova[pType];
        ms= new String[str.length()];
        chert =new String[ms.length];

        for (int i = 0; i < str.length(); i++) {
            ms[i] = String.valueOf(str.charAt(i));
            System.out.println(ms[i]);
        }

        for (int i=0;i< ms.length;i++){
            chert[i]="_";
        }

        for (int i = 0; i < ms.length; i++) {
            k++;
        }
        for (int i = 0; i < k; i++) {
            s = s + " _ ";
        }
        return s;

    }

    private void startButActionPerformed(ActionEvent e){
        spis.clear();
        if (startBut.getText().equals("Начать игру")){
            startBut.setText("Закончить");
            exitBut.setEnabled(false);
            s="";
            k1=0;
            kol=0;
            numberTried=0;
            numberCorrect=0;
            numberUncorrect=0;
            uncorrectTextF.setText("0");
            triedTextF.setText("0");
            correctTextF.setText("0");
            for (int i=0;i<kirillArray.length;i++){
                factorButton[i].setBackground(lightBlue);}
            problemLabel.setText(getProblem(slova));

        }
        else {
            startBut.setText("Начать игру");
            exitBut.setEnabled(true);
            problemLabel.setText("");
            for (int i=0;i<kirillArray.length;i++){
                factorButton[i].setBackground(lightBlue);}
        }
    }
    private void contButActionPerformed(ActionEvent e) {
        spis.clear();
        s="";
        kol=0;
        startBut.setText("Закончить");
        exitBut.setEnabled(false);
        problemLabel.setText("");

        k1=0;
        numberTried=0;
        triedTextF.setText("0");
        for (int i=0;i<kirillArray.length;i++){
            factorButton[i].setBackground(lightBlue);}

        problemLabel.setText(getProblem(slova));
    }

    private void updateScore(boolean correct){
        str1="";
        for (int i=0;i<k1;i++){
            chert[spis.get(i)]=(ms[spis.get(i)]).toUpperCase();
        }
        for (int i=0;i<chert.length;i++){
            str1=str1+" "+chert[i];

        }
        if (correct) {
            problemLabel.setText(str1);
            factorButton[butSelect].setBackground(Color.GREEN);
            corrStr=str1.replaceAll("\\s","");
            System.out.println(str.toUpperCase()+" "+corrStr);

            if (corrStr.equals(str.toUpperCase())) {
                JOptionPane.showMessageDialog(null, "Правильно!",
                        "Угадали!", JOptionPane.INFORMATION_MESSAGE);
                startBut.setEnabled(true);
                ksl++;
                correctTextF.setText(String.valueOf(ksl));
            }
        }else {
            numberTried++;
            triedTextF.setText(String.valueOf(numberTried));
            problemLabel.setText(str1);
            factorButton[butSelect].setBackground(Color.RED);
            if (numberTried>5){
                numberUncorrect++;
                JOptionPane.showMessageDialog(null,"Закончились попытки",
                        "Упс...", JOptionPane.INFORMATION_MESSAGE);
                startBut.setEnabled(true);
                contBut.setEnabled(true);
                problemLabel.setText("");
                uncorrectTextF.setText(String.valueOf(numberUncorrect));
                for (int i=0;i<kirillArray.length-1;i++){
                    factorButton[i].setBackground(lightBlue);}
            }
        }
    }
    int indInd;
    int kol=0;
    private void podskazkaButActionPerformed(ActionEvent e) {

        int ind=myRandom.nextInt(ms.length);
        kol++;
        if (kol<4) {
            while (chert[ind] != "_") {
                ind = myRandom.nextInt(ms.length);
            }
            String b = ms[ind].toUpperCase();
            System.out.println(b);

            for (int i = 0; i < str.length(); i++) {
                if (ms[i].equals(ms[ind])) {
                    chert[i] = ms[i].toUpperCase();
                    indInd = i;

                }
            }
            for (int i = 0; i < 33; i++) {
                if (ms[ind].equals(kirillArray[i])) {
                    butSelect = i;
                }
            }
            updateScore(true);
        }else JOptionPane.showMessageDialog(null, "Подсказки закончились",
                "Упс...", JOptionPane.INFORMATION_MESSAGE);
    }
    private void exitButActionPerformed(ActionEvent e){
        System.exit(0);
    }
}

