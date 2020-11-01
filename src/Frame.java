import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Frame extends JFrame {
    private static final int Width=400;
    private static final int Height=320;
    private static final double PI=3.1415;

    Double Sum;

    boolean Memoryispressed=false;

    private JTextField Text_X;
    private JTextField Text_Y;
    private JTextField Text_Z;

    private JTextField Result;

   private JButton CalcButt=new JButton("Calculate");
   private JButton ResetButt=new JButton("Recet fields");
   private JButton Memory=new JButton("M+");

    private ButtonGroup RadioButtons=new ButtonGroup();

    private Box boxFormulaType=Box.createHorizontalBox();

    private int formulaId=1;

    public Frame(){
        super("Calculator");
        setSize(Width,Height);
        Toolkit kit=Toolkit.getDefaultToolkit();
        setLocation((kit.getScreenSize().width-Width)/2,(kit.getScreenSize().height-Height)/2);

        boxFormulaType.add(Box.createHorizontalGlue());
        AddRadioButton("Formula 1",1);
        AddRadioButton("Formula 2",2);
        RadioButtons.setSelected(RadioButtons.getElements().nextElement().getModel(),true);
        boxFormulaType.add(Box.createHorizontalGlue());

        JLabel Label_X=new JLabel("X:");
        Text_X=new JTextField("0",15);
        Text_X.setMaximumSize(Text_X.getPreferredSize());

        JLabel Label_Y=new JLabel("Y:");
        Text_Y=new JTextField("0",15);
        Text_Y.setMaximumSize(Text_Y.getPreferredSize());

        JLabel Label_Z=new JLabel("Z:");
        Text_Z=new JTextField("0",15);
        Text_Z.setMaximumSize(Text_Z.getPreferredSize());

        Box BoxVariables=Box.createHorizontalBox();

        BoxVariables.add(Box.createHorizontalGlue());

        BoxVariables.add(Label_X);
        BoxVariables.add(Box.createHorizontalStrut(10));
        BoxVariables.add(Text_X);

        BoxVariables.add(Box.createHorizontalStrut(100));

        BoxVariables.add(Label_Y);
        BoxVariables.add(Box.createHorizontalStrut(10));
        BoxVariables.add(Text_Y);

        BoxVariables.add(Box.createHorizontalStrut(100));

        BoxVariables.add(Label_Z);
        BoxVariables.add(Box.createHorizontalStrut(10));
        BoxVariables.add(Text_Z);

        JLabel Label_Result=new JLabel("Result");
        Result=new JTextField("0",15);

        Box BoxResult=Box.createHorizontalBox();
        BoxResult.add(Box.createHorizontalGlue());
        BoxResult.add(Label_Result);
        BoxResult.add(Box.createHorizontalStrut(10));
        BoxResult.add(Result);

        Box Buttonbox=Box.createHorizontalBox();
        Buttonbox.add(Box.createHorizontalGlue());
        Buttonbox.add(BoxResult);
        Buttonbox.add(Box.createHorizontalStrut(30));
        Buttonbox.add(CalcButt);
        Buttonbox.add(Box.createHorizontalStrut(30));
        Buttonbox.add(ResetButt);
        Buttonbox.add(Box.createHorizontalStrut(30));
        Buttonbox.add(Memory);
        Buttonbox.add(Box.createHorizontalGlue());

        CalcButt.addActionListener(new CalcButtListener());
        ResetButt.addActionListener(new ResetButtonListener());
        Memory.addActionListener(new MemoryButtonListener());

        Box GUIBox=Box.createVerticalBox();
        GUIBox.add(Box.createVerticalGlue());

        GUIBox.add(boxFormulaType);
        GUIBox.add(BoxVariables);
        GUIBox.add(BoxResult);
        GUIBox.add(Buttonbox);

        GUIBox.add(Box.createVerticalGlue());

        getContentPane().add(GUIBox,BorderLayout.CENTER);
    }


    public double Formula1(double x,double y,double z){
        return (Math.sin(y)+y*y+Math.exp(Math.cos(y))*Math.pow(Math.log(z)+Math.sin(PI*x*x),0.25));
        //return x+y+z;
    }

    public double Formula2(double x,double y,double z){
        return ((Math.tan(x*x)*Math.pow(y,0.5))/(z*Math.log(x+y)));
        //return x*y*z;
    }

    private void AddRadioButton(String Name,final int formulaId){
        JRadioButton Radio=new JRadioButton(Name);
        Radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent Event) {
Frame.this.formulaId=formulaId;
            }
        });
        RadioButtons.add(Radio);
        boxFormulaType.add(Radio);

    }

    class CalcButtListener implements ActionListener{
       public void actionPerformed(ActionEvent event){
if(!Memoryispressed){
           try {
    Double x = Double.parseDouble(Text_X.getText());
    Double y = Double.parseDouble(Text_Y.getText());
    Double z = Double.parseDouble(Text_Z.getText());
    Double result;
    if (formulaId == 1) {
        result = Formula1(x, y, z);
    } else {
        result = Formula2(x, y, z);
    }
    Result.setText(result.toString());

} catch (NumberFormatException ex) {

    JOptionPane.showMessageDialog(Frame.this,"Wrong number format");
       }}
else{
    Result.setText(Sum.toString());
    Memoryispressed=false;

}
    }

}
class ResetButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            Text_X.setText("0");
            Text_Y.setText("0");
            Text_Z.setText("0");
            Result.setText("0");

            Memoryispressed=false;
        }
}

    class MemoryButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
           double sum;
            if(!Memoryispressed){
            Memoryispressed=true;
                 sum=0;
            }
            else{
                sum=Sum;
            }
            try{
            Double x=Double.parseDouble(Text_X.getText());
            Double y=Double.parseDouble(Text_Y.getText());
            Double z=Double.parseDouble(Text_Z.getText());

            if(formulaId==1){
               sum+=Formula1(x,y,z);
           }
            else{
                sum+=Formula2(x,y,z);
            }
            Sum=sum;}
            catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(Frame.this,"Wrong number format");
            }
        }
    }
}
