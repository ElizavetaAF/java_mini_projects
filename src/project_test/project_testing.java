package project_test;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class project_testing extends JFrame {
    JLabel headGivLab=new JLabel();
    JLabel givLabel=new JLabel();
    JLabel headAnsLabel=new JLabel();
    JLabel[] answerLabel=new JLabel[4];
    JTextField answerTextF=new JTextField();
    JLabel ballLabel=new JLabel();
    JTextField ballTextF=new JTextField();
    JTextArea commentTextF=new JTextArea();
    JButton nextBut=new JButton();
    JButton startBut=new JButton();
    JMenuBar mainMenuBar=new JMenuBar();
    JMenu fileMenu=new JMenu("Файл");
    JMenuItem openMenuI=new JMenuItem("Открыть");
    JMenuItem exitMenuI=new JMenuItem("Выход");
    JMenu optionsMenu=new JMenu("Опции");
    JRadioButtonMenuItem header1MenuI=new JRadioButtonMenuItem("Заголовок 1",true);
    JRadioButtonMenuItem header2MenuI=new JRadioButtonMenuItem("Заголовок 2",false);
    JRadioButtonMenuItem mcMenuI=new JRadioButtonMenuItem("Выбор нескольких ответов",true);
    JRadioButtonMenuItem typeMenuI=new JRadioButtonMenuItem("Введите ответы",false);
    ButtonGroup nameGroup=new ButtonGroup();
    ButtonGroup typeGroup=new ButtonGroup();

    Font myFont=new Font("Arial",Font.PLAIN,16);
    Font headerFont=new Font("Arial",Font.BOLD,18);
    Font examItemFont=new Font("Arial",Font.BOLD,16);
    Dimension itemSize=new Dimension(850,50);
    String examTitle;
    String header1,header2;
    int numberTerms;
    String[] term1=new String[100];
    Random myRandom=new Random();
    String[] items = {
            "Выберете количество вопросов",
            "20",
            "30",
            "40"
    };
    JComboBox comboBox = new JComboBox(items);
    String[] items1 = {
            "Выберете количество баллов",
            "5",
            "10",
            "20"
    };
    JComboBox comboBox1 = new JComboBox(items1);

    public static void main(String[] args){
        new project_testing().show();
    }
    public project_testing(){
        setTitle("Программа для тестирования знаний.");
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                exitForm(evt);
            }
        });
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridCons;
        headGivLab.setPreferredSize(itemSize);
        headGivLab.setFont(headerFont);
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=0;
        gridCons.insets=new Insets(10,10,0,10);
        getContentPane().add(headGivLab,gridCons);
        givLabel.setPreferredSize(itemSize);
        givLabel.setFont(examItemFont);
        givLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        givLabel.setBackground(Color.WHITE);
        givLabel.setForeground(Color.BLUE);
        givLabel.setOpaque(true);
        givLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=1;
        gridCons.insets=new Insets(0,10,0,10);
        getContentPane().add(givLabel,gridCons);
        headAnsLabel.setPreferredSize(itemSize);
        headAnsLabel.setFont(headerFont);
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=2;
        gridCons.insets=new Insets(10,10,0,10);
        getContentPane().add(headAnsLabel,gridCons);

        for (int i=0;i<4;i++){
            answerLabel[i]=new JLabel();
            answerLabel[i].setPreferredSize(itemSize);
            answerLabel[i].setFont(examItemFont);
            answerLabel[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            answerLabel[i].setBackground(Color.WHITE);
            answerLabel[i].setForeground(Color.BLUE);
            answerLabel[i].setOpaque(true);
            answerLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
            gridCons=new GridBagConstraints();
            gridCons.gridx=0;
            gridCons.gridy=i+3;
            gridCons.insets=new Insets(0,10,10,10);
            getContentPane().add(answerLabel[i],gridCons);
            answerLabel[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    answerLabelMousePressed(e);
                }
            });
        }
        answerTextF.setPreferredSize(itemSize);
        answerTextF.setFont(examItemFont);
        answerTextF.setBackground(Color.WHITE);
        answerTextF.setForeground(Color.BLUE);
        answerTextF.setVisible(false);
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=3;
        gridCons.insets=new Insets(0,10,10,10);
        getContentPane().add(answerTextF,gridCons);
        answerTextF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerTextFActionPerformed(e);
            }
        });

        commentTextF.setPreferredSize(new Dimension(370,80));
        commentTextF.setFont(new Font("Courier New",Font.BOLD+Font.ITALIC,18));
        commentTextF.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        commentTextF.setEditable(false);
        commentTextF.setBackground(new Color(255,255,196));
        commentTextF.setForeground(Color.RED);
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=7;
        gridCons.insets=new Insets(0,10,10,10);
        getContentPane().add(commentTextF,gridCons);

        nextBut.setText("Следующий вопрос");
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=8;
        gridCons.insets=new Insets(0,0,10,0);
        getContentPane().add(nextBut,gridCons);
        nextBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextButActionPerformed(e);
            }
        });
        startBut.setText("Начать тест");
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=9;
        gridCons.insets=new Insets(0,00,10,0);
        getContentPane().add(startBut,gridCons);
        startBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButActionPerformed(e);
            }
        });
        ballLabel.setText("Баллы: ");
        ballLabel.setFont(myFont);
        gridCons=new GridBagConstraints();
        gridCons.gridx=1;
        gridCons.gridy=0;
        gridCons.anchor=GridBagConstraints.WEST;
        gridCons.insets=new Insets(10,10,0,0);
        getContentPane().add(ballLabel,gridCons);
        ballTextF.setText("0");
        ballTextF.setPreferredSize(new Dimension(90,30));
        ballTextF.setEditable(false);
        ballTextF.setBackground(Color.RED);
        ballTextF.setForeground(Color.YELLOW);
        ballTextF.setHorizontalAlignment(SwingConstants.CENTER);
        ballTextF.setFont(myFont);
        gridCons=new GridBagConstraints();
        gridCons.gridx=1;
        gridCons.gridy=0;
        gridCons.insets=new Insets(10,-100,0,10);
        getContentPane().add(ballTextF,gridCons);

        comboBox.setEditable(true);
        comboBox.setFont(myFont);
        comboBox.setBackground(Color.decode("#FFEFD5"));
        gridCons=new GridBagConstraints();
        gridCons.gridx=-1;
        gridCons.gridy=7;
        gridCons.insets=new Insets(0,0,70,100);
        getContentPane().add(comboBox,gridCons);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vyborActionPerformed(e);
            }
        });
        comboBox1.setEditable(true);
        comboBox1.setFont(myFont);
        comboBox1.setBackground(Color.decode("#FFEFD5"));
        gridCons=new GridBagConstraints();
        gridCons.gridx=1;
        gridCons.gridy=7;
        gridCons.insets=new Insets(50,0,0,100);
        getContentPane().add(comboBox1,gridCons);
        comboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ballActionPerformed(e);
            }
            private void ballActionPerformed(ActionEvent e) {
            }
        });
        setJMenuBar(mainMenuBar);
        mainMenuBar.add(fileMenu);
        fileMenu.add(openMenuI);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuI);
        mainMenuBar.add(optionsMenu);
        optionsMenu.add(header1MenuI);
        optionsMenu.add(header2MenuI);
        optionsMenu.addSeparator();
        optionsMenu.add(mcMenuI);
        optionsMenu.add(typeMenuI);
        nameGroup.add(header1MenuI);
        nameGroup.add(header2MenuI);
        typeGroup.add(mcMenuI);
        typeGroup.add(typeMenuI);
        openMenuI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openMenuIActionPerformed(e);
            }
        });
        exitMenuI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitMenuIActionPerformed(e);
            }
        });
        header1MenuI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                header1MenuIActionPerformed(e);
            }
        });
        header2MenuI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                header2MenuIActionPerformed(e);
            }
        });
        mcMenuI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mcMenuIActionPerformed(e);
            }
        });
        typeMenuI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeMenuIActionPerformed(e);
            }
        });

        startBut.setEnabled(false);
        nextBut.setEnabled(false);
        optionsMenu.setEnabled(false);
        commentTextF.setText("Выберете количество вопросов\nОткройте файл, чтобы начать!");

        pack();
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int)(0.5*(screenSize.width-getWidth())),(int)(0.5*(screenSize.height-getHeight())),getWidth(),getHeight());

    }
    private void exitForm(WindowEvent evt){
        System.exit(0);
    }
    private void answerLabelMousePressed(MouseEvent e) {
        boolean correct=false;
        if (startBut.getText().equals("Начать тест")||nextBut.isEnabled()){
            return;}
        JLabel select=(JLabel) e.getSource();
        int labelSelected=-1;
        for (int i=0;i<4;i++){
            if (select==answerLabel[i]){
                labelSelected=i;
                break;
            }
        }
        if (labelSelected==-1){
            return; // не определен выбранный ответ
        }
        if (header1MenuI.isSelected()){
            if (select.getText().equals(term1[Number]))
                correct=true;
        }
        if (header2MenuI.isSelected()){
            if (select.getText().equals(answerOptions[Number][4]))
                correct=true;
        }
        updateScore(correct);
    }
    int ball,ch; String s;
    private void updateScore(boolean correct){
        if (correct){
            if ((comboBox1.getSelectedItem()=="5")|(comboBox1.getSelectedItem()=="10")|(comboBox1.getSelectedItem()=="20")){
                s=(String)comboBox1.getSelectedItem();
                ch=Integer.parseInt(s);
                ball += ch;
                ballTextF.setText(String.valueOf(ball));
            }
            numberCorrect++;
            commentTextF.setText(centerTextArea("ПРАВИЛЬНО!"));
        }else commentTextF.setText(centerTextArea("Извините...Правильный ответ"));

        if (numberTried==numberTerms){
            nextBut.setEnabled(false);
        }
        if (mcMenuI.isSelected()){
            if (header1MenuI.isSelected())
                answerLabel[0].setText(term1[Number]);
            else
                answerLabel[0].setText(answerOptions[Number][4]);
            answerLabel[1].setText("");
            answerLabel[2].setText("");
            answerLabel[3].setText("");
        }
        if (typeMenuI.isSelected()){
            if (header1MenuI.isSelected()){ answerTextF.setText(term1[Number]);}
            else{ answerTextF.setText(answerOptions[Number][4]);}
        }
        startBut.setEnabled(true);
        nextBut.setEnabled(true);
        nextBut.requestFocus();
    }
    private void answerTextFActionPerformed(ActionEvent e) {
        boolean correct;
        String ucTypeAnswer, ucAnswer;
        if (startBut.getText().equals("Начать тест")||nextBut.isEnabled())
            return;
        answerTextF.setEditable(false);
        //numberTried++;
        ucTypeAnswer=answerTextF.getText().toUpperCase();
        if (header1MenuI.isSelected()) ucAnswer=term1[Number].toUpperCase();
        else
            ucAnswer=answerOptions[Number][4].toUpperCase();
        correct=false;
        if (ucTypeAnswer.equals(ucAnswer)||soundex(ucTypeAnswer).equals(soundex(ucAnswer)))
            correct=true;
        updateScore(correct);
    }
    private void nextButActionPerformed(ActionEvent e) {
        nextBut.setEnabled(false);
        nextQuestion();
    }
    int numberTried,numberCorrect;
    private void startButActionPerformed(ActionEvent e) {
        String message, message1;
        if (startBut.getText().equals("Начать тест")){
            startBut.setText("Остановить тест");
            nextBut.setEnabled(false);
            numberTried = 0;
            numberCorrect=0;
            ball=0;
            ballTextF.setText("0");
            commentTextF.setText("");
            fileMenu.setEnabled(false);
            optionsMenu.setEnabled(false);
            nextQuestion();
        }else {
            startBut.setText("Начать тест");
            nextBut.setEnabled(false);

            if (numberTried>0){
                message="Вопросы: "+String.valueOf(numberTried-1)+"\n";
                message1="Количество баллов: "+String.valueOf(ball)+"\n";
                message+="Правильные: "+String.valueOf(numberCorrect)+"\n\n";
                message+="Оценки: "+
                        new DecimalFormat("0.0").format(100.0*((double) numberCorrect/numberTried))+"%";
                JOptionPane.showConfirmDialog(null,message1+message,examTitle+"Результаты",JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
                if (100.0*((double) numberCorrect/numberTried)>50){
                    message="Вы сдали!";
                    JOptionPane.showConfirmDialog(null,message,examTitle+"Итог",JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    message="Вы не сдали!";
                    JOptionPane.showConfirmDialog(null,message,examTitle+"Итог",JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
            givLabel.setText("");
            answerLabel[0].setText("");
            answerLabel[1].setText("");
            answerLabel[2].setText("");
            answerLabel[3].setText("");
            answerTextF.setText("");
            commentTextF.setText(centerTextArea("Выберете опцию\nНажмите начать тест"));
            fileMenu.setEnabled(true);
            optionsMenu.setEnabled(true);
        }
    }
    String[][] answerOptions=new String[100][5];
    private void openMenuIActionPerformed(ActionEvent e) {

        JFileChooser openChooser=new JFileChooser();
        openChooser.setDialogType(JFileChooser.OPEN_DIALOG);
        openChooser.setDialogTitle("Открыть файл с тестом");
        openChooser.addChoosableFileFilter(new FileNameExtensionFilter("Тестовые файлы","csv"));
        if (openChooser.showOpenDialog(this) ==JFileChooser.APPROVE_OPTION){
            try (BufferedReader inputFile = new BufferedReader(new FileReader(openChooser.getSelectedFile()))){
                String myLine;
                myLine=inputFile.readLine();
                examTitle=parseLeft(myLine);
                myLine=inputFile.readLine();
                header1=parseLeft(myLine);
                header2=parseRight(myLine);
                numberTerms=0;

                if ((String)comboBox.getSelectedItem()=="20"){
                    while ((myLine=inputFile.readLine())!=null && numberTerms<21){
                        numberTerms++;
                        String[] mas=myLine.split(";");
                        term1[numberTerms-1]=mas[0];
                        answerOptions[numberTerms-1]=new String[mas.length-1];

                        for (int i=0;i<mas.length-1;i++){
                            answerOptions[numberTerms-1][i]=mas[i+1];
                        }
                    }}
                if ((String)comboBox.getSelectedItem()=="30"){
                    while ((myLine=inputFile.readLine())!=null && numberTerms<31){
                        numberTerms++;

                        String[] mas=myLine.split(";");
                        term1[numberTerms-1]=mas[0];
                        answerOptions[numberTerms-1]=new String[mas.length-1];

                        for (int i=0;i<mas.length-1;i++){
                            answerOptions[numberTerms-1][i]=mas[i+1];
                        }
                    }}
                if ((String)comboBox.getSelectedItem()=="40"){
                    while ((myLine=inputFile.readLine())!=null && numberTerms<41){
                        numberTerms++;

                        String[] mas=myLine.split(";");
                        term1[numberTerms-1]=mas[0];
                        answerOptions[numberTerms-1]=new String[mas.length-1];

                        for (int i=0;i<mas.length-1;i++){
                            answerOptions[numberTerms-1][i]=mas[i+1];
                        }
                    }}
                if (numberTerms<5){
                    JOptionPane.showConfirmDialog(null,"В тестовом файле должно быть не менее 5 записей",
                            "Ошибка в тестовом файле", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                inputFile.close();
                this.setTitle("Выбор нескольких ответов - "+examTitle);
                header1MenuI.setText(header1+","+header2);
                header2MenuI.setText(header2+","+header1);
                if (header1MenuI.isSelected()){
                    headGivLab.setText(header2);
                    headAnsLabel.setText(header1);
                }else {
                    headGivLab.setText(header1);
                    headAnsLabel.setText(header2);
                }
                startBut.setEnabled(true);
                optionsMenu.setEnabled(true);
                commentTextF.setText("Файл загружен, выберете опции\nНажмите начать тест!");
            }catch (Exception ex){
                JOptionPane.showConfirmDialog(null,
                        "Ошибка чтения входного файла. Убедитесь, что файл имеет правильный формат.",
                        "Ошибка тестового файла", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }
    int Number;
    String[] randomQuest=new String[4];
    int correctQuest;
    private void nextQuestion(){
        numberTried++;
        Number++;
        commentTextF.setText("");
        //correctAnswer=myRandom.nextInt(numberTerms);

        randomQuest[0]=term1[Number];
        randomQuest[1]=term1[myRandom.nextInt(numberTerms)];

        while (randomQuest[0] == randomQuest[1]) {
            randomQuest[1] = term1[myRandom.nextInt(numberTerms)];
        }
        randomQuest[2] = term1[myRandom.nextInt(numberTerms)];

        while ((randomQuest[0] == randomQuest[2]) | (randomQuest[1] == randomQuest[2])) {
            randomQuest[2] = term1[myRandom.nextInt(numberTerms)];
        }
        randomQuest[3] = term1[myRandom.nextInt(numberTerms)];

        while ((randomQuest[0] == randomQuest[2]) | (randomQuest[1] == randomQuest[3]) | (randomQuest[2] == randomQuest[3])) {
            randomQuest[3] = term1[myRandom.nextInt(numberTerms)];
        }
        Collections.shuffle(Arrays.asList(randomQuest));

        for (int i=0;i<4;i++){
            if (randomQuest[i]==term1[Number]) correctQuest=i;
        }

        if (header1MenuI.isSelected()){
            givLabel.setText(answerOptions[Number][4]);
        }else {
            givLabel.setText(term1[Number]);
        }

        //вывод вариантов ответа
        if (mcMenuI.isSelected()) {
            for (int i = 0; i < 4; i++) {
                if (header1MenuI.isSelected()&&(numberTried>20)&&(String)comboBox.getSelectedItem()=="20") {
                    //numberTried=numberTried-1;
                    answerLabel[i].setText("");
                    return;
                }else { answerLabel[i].setText(randomQuest[i]);}
                if (header1MenuI.isSelected()&&(numberTried>30)&&(String)comboBox.getSelectedItem()=="30") {
                    //numberTried=numberTried-1;
                    answerLabel[i].setText("");
                    return;
                }else { answerLabel[i].setText(randomQuest[i]);}
                if (header1MenuI.isSelected()&&(numberTried>40)&&(String)comboBox.getSelectedItem()=="40") {
                    //numberTried=numberTried-1;
                    answerLabel[i].setText("");
                    return;
                }else { answerLabel[i].setText(randomQuest[i]);}

                if (header2MenuI.isSelected()){
                    answerLabel[i].setText(answerOptions[Number][i]);
                }
            }
        }else {
            answerTextF.setEditable(true);
            answerTextF.setText("");
            answerTextF.requestFocus();
        }
    }
    private void vyborActionPerformed(ActionEvent e) {
    }
    private String parseLeft(String s){
        int cl;
        cl=s.indexOf(";");
        return (s.substring(0,cl));
    }
    private String parseRight(String s){
        int cl;
        cl=s.indexOf(";");
        return (s.substring(cl+1));
    }
    private String centerTextArea(String s){
        int charsPerLine=33;
        String sOut="";
        int j=s.indexOf("\n");
        int nSpaces;
        if (j==-1){
            sOut="\n"+spacePadding((int) ((charsPerLine-s.length())/2))+s;
        }else {
            String l=s.substring(0,j);
            sOut="\n"+spacePadding((int) ((charsPerLine-l.length())/2))+l;
            l=s.substring(j+1);
            sOut="\n"+spacePadding((int) ((charsPerLine-l.length())/2))+l;
        } return (sOut);
    }
    private String spacePadding(int n){
        String s="";
        if (n!=0)
            for (int i=0;i<n;i++) s+=" ";
        return (s);
    }
    private void exitMenuIActionPerformed(ActionEvent e) {
        System.exit(0);
    }
    private void header1MenuIActionPerformed(ActionEvent e) {
        headGivLab.setText(header2);
        headAnsLabel.setText(header1);
    }
    private void header2MenuIActionPerformed(ActionEvent e) {
        headGivLab.setText(header1);
        headAnsLabel.setText(header2);
    }
    private void mcMenuIActionPerformed(ActionEvent e) {
        answerLabel[0].setVisible(true);
        answerLabel[1].setVisible(true);
        answerLabel[2].setVisible(true);
        answerLabel[3].setVisible(true);
        answerTextF.setVisible(false);
    }
    private void typeMenuIActionPerformed(ActionEvent e) {
        answerLabel[0].setVisible(false);
        answerLabel[1].setVisible(false);
        answerLabel[2].setVisible(false);
        answerLabel[3].setVisible(false);
        answerTextF.setVisible(true);
    }
    public String soundex(String w){
        String wTemp,s="";
        int l;int wPrev, wSnd, cIndex;
        int[] wSound={0,1,2,3,0,1,2,0,0,2,2,4,5,5,0,1,2,6,2,3,0,1,0,2,0,2};
        wTemp=w.toUpperCase();
        l=w.length();
        System.out.println(numberTried);
        if (l!=0){
            s=String.valueOf(w.charAt(0));
            wPrev=0;
            if (l>1){
                for (int i=1;i<1;i++){
                    cIndex=(int) wTemp.charAt(i)-65;
                    if (cIndex>=0 && cIndex<=25){
                        wSnd=wSound[cIndex]+48;
                        if (wSnd!=48 && wSnd!=wPrev){
                            s+=String.valueOf((char) wSnd);
                        }
                        wPrev=wSnd;
                    }
                }
            }
            else s="";
        }
        return (s);
    }

}

