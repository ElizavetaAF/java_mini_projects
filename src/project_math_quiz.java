import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class project_math_quiz extends JFrame {
    public static void main (String[] args){
        new project_math_quiz().show();
    }
    JLabel triedLabel = new JLabel();
    JTextField triedTextF=new JTextField();
    JLabel correctLabel=new JLabel();
    JTextField correctTextF=new JTextField();
    JLabel uncorrectLabel=new JLabel();
    JTextField uncorrectTextF=new JTextField();
    JLabel problemLabel = new JLabel();
    JLabel dividerLabel=new JLabel();
    Font myFont=new Font("Arial",Font.PLAIN,16);
    JPanel typePanel=new JPanel();
    JCheckBox[] typeChBox=new JCheckBox[4];
    Color lightBlue=new Color(192,192,255);
    JPanel factorPanel = new JPanel();
    ButtonGroup factorButtonGroup=new ButtonGroup();
    JRadioButton[] factorRadioButton=new JRadioButton[11];
    JPanel timerPanel =new JPanel();
    ButtonGroup timerButtonGroup=new ButtonGroup();
    JRadioButton[] timerRadioButton=new JRadioButton[3];
    JTextField timerTextF =new JTextField();
    JScrollBar timeScrollBar=new JScrollBar();
    JButton startBut=new JButton();
    JButton exitBut=new JButton();
    JButton slovoBut=new JButton();
    Random myRandom = new Random();
    int numberTried, numberCorrect, numberUncorrect;
    int correctAnswer,numberDigits;
    String problem;
    Timer problemsTimer;
    int problemTime;
    SpinnerDateModel smod;
    JSpinner spin; Calendar calendar;
    public project_math_quiz(){
        setTitle("Математическая викторина");
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

        correctLabel.setText("Правильные ответы: ");
        correctLabel.setFont(myFont);
        gridCons=new GridBagConstraints();
        gridCons.gridx=2;
        gridCons.gridy=0;
        gridCons.anchor=GridBagConstraints.EAST;
        gridCons.insets=new Insets(10,10,0,10);
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
        gridCons.insets=new Insets(10,0,0,0);
        getContentPane().add(correctTextF,gridCons);

        uncorrectLabel.setText("Неправильные ответы: ");
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
        gridCons.insets=new Insets(10,0,0,0);
        getContentPane().add(uncorrectTextF,gridCons);

        problemLabel.setText("");
        problemLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        problemLabel.setPreferredSize(new Dimension(450,100));
        problemLabel.setBackground(Color.WHITE);
        problemLabel.setOpaque(true);
        problemLabel.setFont(new Font("Comic Sans MS",Font.PLAIN,48));
        problemLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=1;
        gridCons.gridwidth=5;
        gridCons.insets=new Insets(10,10,0,10);
        getContentPane().add(problemLabel,gridCons);
        problemLabel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                problemLabelKeyPr(e);
            }
        });

        dividerLabel.setPreferredSize(new Dimension(450,10));
        dividerLabel.setBackground(Color.RED);
        dividerLabel.setOpaque(true);
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=2;
        gridCons.gridwidth=5;
        gridCons.insets=new Insets(10,10,10,10);
        getContentPane().add(dividerLabel,gridCons);

        UIManager.put("TitleBorder.font",new Font("Arial",Font.BOLD,14));
        typePanel.setPreferredSize(new Dimension(130,130));
        typePanel.setBorder(BorderFactory.createTitledBorder("Тип: "));
        typePanel.setBackground(lightBlue);
        typePanel.setLayout(new GridBagLayout());
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=3;
        gridCons.gridwidth=2;
        gridCons.anchor=GridBagConstraints.NORTH;
        //gridCons.insets=new Insets(10,10,0,10);
        getContentPane().add(typePanel,gridCons);

        for (int i=0;i<4;i++){
            typeChBox[i]=new JCheckBox();
            typeChBox[i].setBackground(lightBlue);
            gridCons=new GridBagConstraints();
            gridCons.gridx=0;
            gridCons.gridy=i;
            gridCons.anchor=GridBagConstraints.WEST;
            typePanel.add(typeChBox[i],gridCons);
            typeChBox[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    typeCheckBoxActionPerformed(e);
                }
            });
        }
        typeChBox[0].setText("Сложение");
        typeChBox[1].setText("Вычитание");
        typeChBox[2].setText("Умножение");
        typeChBox[3].setText("Деление");
        typeChBox[0].setSelected(true);

        factorPanel.setPreferredSize(new Dimension(130,130));
        factorPanel.setBorder(BorderFactory.createTitledBorder("Элемент:"));
        factorPanel.setBackground(lightBlue);
        factorPanel.setLayout(new GridBagLayout());
        gridCons=new GridBagConstraints();
        gridCons.gridx=2;
        gridCons.gridy=3;
        gridCons.gridwidth=2;
        gridCons.anchor=GridBagConstraints.NORTH;
        getContentPane().add(factorPanel,gridCons);
        int x=2;
        int y=0;
        for (int i=0;i<11;i++){
            factorRadioButton[i]=new JRadioButton();
            factorRadioButton[i].setText(String.valueOf(i));
            factorRadioButton[i].setBackground(lightBlue);
            factorButtonGroup.add(factorRadioButton[i]);
            gridCons=new GridBagConstraints();
            if (i<10){
                gridCons.gridx=x;
                gridCons.gridy=y;
            }
            else {
                gridCons.gridx=0;
                gridCons.gridy=0;
                gridCons.gridwidth=2;
            }
            gridCons.anchor=GridBagConstraints.WEST;
            factorPanel.add(factorRadioButton[i],gridCons);
            factorRadioButton[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    factorRadioButtonActionPerformed(e);
                }
            });
            x++;
            if (x>2){
                x=0; y++;
            }
        }
        factorRadioButton[10].setText("Случайный");
        factorRadioButton[10].setSelected(true);

        timerPanel.setPreferredSize(new Dimension(130,130));
        timerPanel.setBorder(BorderFactory.createTitledBorder("Секундомер"));
        timerPanel.setBackground(lightBlue);
        timerPanel.setLayout(new GridBagLayout());
        gridCons=new GridBagConstraints();
        gridCons.gridx=4;
        gridCons.gridy=3;
        gridCons.insets=new Insets(0,0,0,10);
        gridCons.anchor=GridBagConstraints.NORTH;
        getContentPane().add(timerPanel,gridCons);
        for (int i=0;i<3;i++){
            timerRadioButton[i]=new JRadioButton();
            timerRadioButton[i].setBackground(lightBlue);
            timerButtonGroup.add(timerRadioButton[i]);
            gridCons=new GridBagConstraints();
            gridCons.gridx=0;
            gridCons.gridy=i;
            gridCons.gridwidth=2;
            gridCons.anchor=GridBagConstraints.WEST;
            timerPanel.add(timerRadioButton[i],gridCons);
            timerRadioButton[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    timerRadioButtonActionPerformed(e);
                }
            });
        }

        timerRadioButton[0].setText("Выключить");
        timerRadioButton[1].setText("Прямой отсчет");
        timerRadioButton[2].setText("Обратный отсчет");
        timerRadioButton[0].setSelected(true);
        timerTextF.setText("Выключить");
        timerTextF.setPreferredSize(new Dimension(90,25));
        timerTextF.setEditable(false);
        timerTextF.setBackground(Color.WHITE);
        timerTextF.setForeground(Color.RED);
        timerTextF.setHorizontalAlignment(SwingConstants.CENTER);
        timerTextF.setFont(myFont);
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=3;
        gridCons.anchor=GridBagConstraints.WEST;
        gridCons.insets=new Insets(5,0,0,0);
        //timerPanel.add(timerTextF,gridCons);

        timeScrollBar.setPreferredSize(new Dimension(20,25));
        timeScrollBar.setMinimum(1);
        timeScrollBar.setMaximum(60);
        timeScrollBar.setValue(1);
        timeScrollBar.setBlockIncrement(1);
        timeScrollBar.setUnitIncrement(1);
        timeScrollBar.setOrientation(JScrollBar.VERTICAL);
        timeScrollBar.setEnabled(false);
        gridCons=new GridBagConstraints();
        gridCons.gridx=1;
        gridCons.gridy=3;
        gridCons.anchor=GridBagConstraints.WEST;
        gridCons.insets=new Insets(5,0,0,0);
        //timerPanel.add(timeScrollBar,gridCons);
        timeScrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                timeScrollBarAdjuatmentValueChaged(e);
            }
        });

        startBut.setText("Начать");
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=4;
        gridCons.gridwidth=2;
        gridCons.insets=new Insets(10,0,10,0);
        getContentPane().add(startBut,gridCons);
        startBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButActionPerformed(e);
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
        slovoBut.setText("Угадай слово");
        gridCons=new GridBagConstraints();
        gridCons.gridx=3;
        gridCons.gridy=4;
        gridCons.gridwidth=2;
        gridCons.insets=new Insets(10,0,10,0);
        getContentPane().add(slovoBut,gridCons);
        slovoBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slovoButActionPerformed(e);
            }

            private void slovoButActionPerformed(ActionEvent e) {
                new project_game().show();
            }
        });

        problemsTimer=new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                problemsTimerActionPerformed(e);
            }
        });

        smod=new SpinnerDateModel();
        smod.setCalendarField(Calendar.SECOND);//установка поля модели данных на секунды

        spin=new JSpinner(smod);
        JSpinner.DateEditor editor=new JSpinner.DateEditor(spin,"HH:mm:ss");
        spin.setEditor(editor);
        InitialTime();
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=4;
        gridCons.insets=new Insets(10,0,10,0);
        timerPanel.add(spin,gridCons);

        pack();
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int)(0.5*(screenSize.width-getWidth())),
                (int)(0.5*(screenSize.height-getHeight())),getWidth(),
                getHeight());
    }
    private void exitForm(WindowEvent e){
        System.exit(0);
    }
    private void typeCheckBoxActionPerformed(ActionEvent e){
        int numberChecks;
        int clickedBox=0;
        String s=e.getActionCommand();
        if (s.equals("Сложение")) clickedBox=0;
        else if (s.equals("Вычитание")) clickedBox=1;
        else if (s.equals("Умножение")) clickedBox=2;
        else if (s.equals("Деление")) clickedBox=3;
        numberChecks=0;
        if (typeChBox[0].isSelected()) numberChecks++;
        if (typeChBox[1].isSelected()) numberChecks++;
        if (typeChBox[2].isSelected()) numberChecks++;
        if (typeChBox[3].isSelected()){
            numberChecks++;
            if(factorRadioButton[0].isSelected())
                factorRadioButton[1].doClick();
            factorRadioButton[0].setEnabled(false);}
        else{
            factorRadioButton[0].setEnabled(true);
        }
        if (numberChecks==0)
            typeChBox[clickedBox].setSelected(true);
        problemLabel.requestFocus();

    }
    private void factorRadioButtonActionPerformed(ActionEvent e){

    }
    private void timerRadioButtonActionPerformed(ActionEvent e){
        if (timerRadioButton[0].isSelected()){
            timerTextF.setText("Off");
            timeScrollBar.setEnabled(false);
        }else if (timerRadioButton[1].isSelected()){
            problemTime=0;
            timerTextF.setText(getTime(problemTime));
            timeScrollBar.setEnabled(false);
        }else if (timerRadioButton[2].isSelected()){
            problemTime=30*timeScrollBar.getValue();
            timerTextF.setText(getTime(problemTime));
            timeScrollBar.setEnabled(true);

        }}
    private void timeScrollBarAdjuatmentValueChaged(AdjustmentEvent e){

    }
    private void startButActionPerformed(ActionEvent e){
        if (startBut.getText().equals("Начать")){
            if (timerRadioButton[1].isSelected()){
                liveCountDown();}
            if (timerRadioButton[2].isSelected()){
                countDown();}
            startBut.setText("Остановить");
            exitBut.setEnabled(false);
            numberTried=0;
            numberCorrect=0;
            triedTextF.setText("0");
            correctTextF.setText("0");
            problemLabel.setText(getProblem());
        }
        else {
            JOptionPane.showMessageDialog(null, "Сделано "+correctTextF.getText()+" из "+triedTextF.getText());

            if (timerRadioButton[1].isSelected()){
                countdownThread.interrupt();
                JOptionPane.showMessageDialog(null,"Выполнена остановка теста");
                InitialTime();
            }
            if (timerRadioButton[2].isSelected()){
                countdownThread.interrupt();
                JOptionPane.showMessageDialog(null,"Выполнена остановка теста");
                InitialTime();
            }
            startBut.setText("Начать");
            exitBut.setEnabled(true);
            problemLabel.setText("");
        }
        if (timerRadioButton[0].isSelected()){
            timerTextF.setText("Off");
            timeScrollBar.setEnabled(false);
        }else if(timerRadioButton[1].isSelected()){
            problemTime=0;
            timerTextF.setText(getTime(problemTime));
            timeScrollBar.setEnabled(false);
        }else if (timerRadioButton[2].isSelected()){
            problemTime=30*timeScrollBar.getValue();
            timerTextF.setText(getTime(problemTime));
            timeScrollBar.setEnabled(true);
        }
        else {
            timerRadioButton[0].setEnabled(true);
            timerRadioButton[1].setEnabled(true);
            timerRadioButton[2].setEnabled(true);
            if (timerRadioButton[2].isSelected())
                timeScrollBar.setEnabled(true);
            problemsTimer.stop();
        }
    }
    private String getProblem(){
        int pType,p,number,factor;p=0;
        yourAns=""; digitNumber=1;
        problemLabel.requestFocus();
        do{
            pType=myRandom.nextInt(4)+1;
            if (pType==1 && typeChBox[0].isSelected()){
                p=pType;
                number=myRandom.nextInt(10);
                factor=getFactor(1);
                correctAnswer=number+factor;
                problem=String.valueOf(number)+" + "+String.valueOf(factor)+" = ";
            }
            else if (pType==2 &&typeChBox[1].isSelected()){
                p=pType;
                factor=getFactor(2);
                correctAnswer=myRandom.nextInt(10);
                number=correctAnswer+factor;
                problem=String.valueOf(number)+" - "+String.valueOf(factor)+" = ";
            }
            else if (pType==3 &&typeChBox[2].isSelected()){
                p=pType;
                number=myRandom.nextInt(10);
                factor=getFactor(3);
                correctAnswer=number*factor;
                problem=String.valueOf(number)+" x "+String.valueOf(factor)+" = ";
            }else if (pType==4 &&typeChBox[3].isSelected()){
                p=pType;
                factor=getFactor(4);
                correctAnswer=myRandom.nextInt(10);
                number=correctAnswer*factor;
                problem=String.valueOf(number)+" / "+String.valueOf(factor)+" = ";
            }
        }while (p==0);
        if (correctAnswer<10){
            numberDigits=1;
            return (problem+ "?");
        }
        else {
            numberDigits=2;
            return (problem+ "??");
        }
    }
    int getFactor(int p){
        if(factorRadioButton[10].isSelected()){
            if (p==4) return (myRandom.nextInt(9)+1);
            else return (myRandom.nextInt(10));
        }
        else {
            for (int i=0;i<10;i++){
                if (factorRadioButton[i].isSelected())
                    return (i);
            }
            return 0;
        }
    }
    String yourAns;
    int digitNumber=1;
    private void problemLabelKeyPr(KeyEvent e) {
        if (startBut.getText().equals("Начать")) return;
        if (e.getKeyChar()>='0' && e.getKeyChar() <='9'){
            yourAns+=e.getKeyChar();
            problemLabel.setText(problem+yourAns);
            if(digitNumber!=numberDigits){
                digitNumber++;
                problemLabel.setText(problemLabel.getText()+ "?");
                return;
            }
        }else {
            numberTried++;
            if (Integer.valueOf(yourAns).intValue()==correctAnswer){
                numberCorrect++;
            }
            else{ numberUncorrect++;}
            triedTextF.setText(String.valueOf(numberTried));
            correctTextF.setText(String.valueOf(numberCorrect));
            uncorrectTextF.setText(String.valueOf(numberUncorrect));
            problemLabel.setText(getProblem());
        }
    }

    private void problemsTimerActionPerformed(ActionEvent e) {
        if (timerRadioButton[1].isSelected()){
            problemTime++;
            timerTextF.setText(getTime(problemTime));
            if (problemTime>=1800){
                startBut.doClick();
                return;
            }
            else {
                problemTime--;
                timerTextF.setText(getTime(problemTime));
                if (problemTime==0){
                    startBut.doClick();
                    return;
                }
            }
        }
    }
    String getTime(int s){
        int min,sec;
        String ms,ss;
        min=(int)(s/60);
        sec=s-60*min;
        ms=String.valueOf(min);
        ss=String.valueOf(sec);
        if (sec<10) ss="0"+ss;
        return (ms+ ":"+ ss);
    }
    public void InitialTime(){
        // Устанавливаем начальное время
        calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        spin.setValue(calendar.getTime());
    }
    Thread countdownThread;
    public void countDown(){
        // Запускаем обратный отсчет времени
        countdownThread = new Thread(() -> {
            try {
                // Получаем введенное пользователем время
                Date targetTime = (Date) spin.getValue();

                // Получаем разницу между текущим временем и введенным временем в миллисекундах
                // Запускаем обратный отсчет пока время не станет равным нулю
                while (true) {
                    Date currentValue = smod.getDate();
                    if ((currentValue.getSeconds()<= 0) &&(currentValue.getMinutes()<= 0)&&(currentValue.getHours()<= 0)) {
                        break;
                    }
                    Thread.sleep(1000); // Ждем 1 секунду
                    currentValue.setTime(currentValue.getTime() - 1000); // Уменьшаем время на 1 секунду
                    smod.setValue(currentValue); // Обновляем значение модели
                }

                // Таймер достиг нуля
                JOptionPane.showMessageDialog(null, "Время истекло!");
                startBut.setText("Начать");
                exitBut.setEnabled(true);
                problemLabel.setText("");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        countdownThread.start();
    }
    public void liveCountDown(){

        // Запускаем обратный отсчет времени
        countdownThread = new Thread(() -> {
            try {
                // Получаем введенное пользователем время
                final Date targetTime = (Date) spin.getValue();
                InitialTime();
                // Получаем разницу между текущим временем и введенным временем в миллисекундах
                long difference = targetTime.getTime();

                // Запускаем прямой отсчет пока время не станет равным нулю
                while (true) {
                    Date currentValue = smod.getDate();

                    if (currentValue.getHours()==targetTime.getHours() && currentValue.getMinutes()==targetTime.getMinutes()
                            && currentValue.getSeconds()==targetTime.getSeconds()) {
                        break;
                    }
                    Thread.sleep(1000); // Ждем 1 секунду
                    currentValue.setTime(currentValue.getTime() + 1000); // Увеличиваем время на 1 секунду
                    smod.setValue(currentValue); // Обновляем значение модели
                }

                // Таймер достиг указанного времени
                JOptionPane.showMessageDialog(null, "Указанное время истекло!");
                startBut.setText("Начать");
                exitBut.setEnabled(true);
                problemLabel.setText("");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        countdownThread.start();
    }
    private void exitButActionPerformed(ActionEvent e){
        System.exit(0);
    }
}
