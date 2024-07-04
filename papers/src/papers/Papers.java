package papers;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class Papers extends JFrame {

    JButton[] pais = new JButton[7];
    JButton rec = new JButton("recomeçar");
    JButton cola = new JButton("cola");
    String[][] cidades = new String[7][3];
    JLabel perg = new JLabel();
    JLabel cont = new JLabel("1/21");
    Boolean[][] a = new Boolean[7][3];
    Timer timer = new Timer();
    int count = 0;
    int x, y;

    Papers() {
        setSize(800, 900);
        setResizable(true);
        setDefaultCloseOperation(3);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        add(perg);
        add(cont);
        add(rec);
        add(cola);
        pais[0] = new JButton("Obristão");
        cidades[0][0] = new String("Skal");
        cidades[0][1] = new String("Lorndaz");
        cidades[0][2] = new String("Mergerous");
        pais[1] = new JButton("Arstotzka");
        cidades[1][0] = new String("Orvech Vonor");
        cidades[1][1] = new String("Grestin Leste");
        cidades[1][2] = new String("Paradizna");
        pais[2] = new JButton("Kolechia");
        cidades[2][0] = new String("Yurkópolis");
        cidades[2][1] = new String("Vedor");
        cidades[2][2] = new String("Grestin Oeste");
        pais[3] = new JButton("Impor");
        cidades[3][0] = new String("Emkyo");
        cidades[3][1] = new String("Haihan");
        cidades[3][2] = new String("Tsunkeido");
        pais[4] = new JButton("Antegria");
        cidades[4][0] = new String("São Marmero");
        cidades[4][1] = new String("Glorian");
        cidades[4][2] = new String("Perdiz");
        pais[5] = new JButton("Federação Unida");
        cidades[5][0] = new String("Grão Rapid");
        cidades[5][1] = new String("Shingleton");
        cidades[5][2] = new String("Koristópolis");
        pais[6] = new JButton("Republia");
        cidades[6][0] = new String("Glorian Real");
        cidades[6][1] = new String("Lesrenadi");
        cidades[6][2] = new String("Bostan");
        for (int i = 0; i < 7; i++) {
            add(pais[i]);
            pais[i].setBounds(150 + 250 * (int) (i / 4), ((-4 * (int) (i / 4)) + i) * 60 + 300, 200, 50);
            pais[i].setForeground(Color.black);
            pais[i].setFont(new Font("Arial", 1, 20));
        }
        perg.setOpaque(true);
        perg.setBackground(Color.white);
        perg.setFont(new Font("Arial", 1, 30));
        perg.setHorizontalAlignment(JLabel.CENTER);
        perg.setBounds(150, 150, 450, 70);
        cont.setFont(new Font("Arial", 1, 20));
        cont.setHorizontalAlignment(JLabel.CENTER);
        cont.setBounds(325, 100, 100,50);
        rec.setFont(new Font("Arial", 1, 20));
        rec.setHorizontalAlignment(JLabel.CENTER);
        rec.setBounds(300, 50, 150,50);
        cola.setFont(new Font("Arial", 1, 20));
        cola.setHorizontalAlignment(JLabel.CENTER);
        cola.setBounds(325, 600, 100,50);
        setFalse();
        setNovo();
        for (int i = 0; i < 7; i++) {
            final int in = i;
            pais[in].addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (in == x) {
                        TimerTask task = new TimerTask() {
                            @Override
                            public void run() {
                                perg.setForeground(Color.black);
                                ability(true);
                                setNovo();
                            }
                        };
                        perg.setForeground(Color.green);
                        ability(false);
                        timer.schedule(task, 1000);
                    } else {
                        TimerTask task = new TimerTask() {
                            @Override
                            public void run() {
                                perg.setForeground(Color.black);
                                ability(true);
                                setNovo();
                            }
                        };
                        perg.setForeground(Color.red);
                        perg.setText(perg.getText() + " : " + pais[x].getText());
                        ability(false);
                        timer.schedule(task, 1000);
                    }
                }
            });
        }
        rec.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count = 0;
                setFalse();
                setNovo();
            }
        });
        cola.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, colar());
            }
        });
    }
    public String colar(){
        String aqui = "";
        for (int i = 0; i < 7; i++) {
            aqui += pais[i].getText()+"\n";
            for (int j = 0; j < 3; j++) {
                aqui+= "    "+cidades[i][j]+"\n";
            }
        }
        return aqui;
    }
    public void ability(boolean as){
        for (int i = 0; i < 7; i++) {
            pais[i].setEnabled(as);
        }
    }

    public void setNovo() {
        if (count == 21) {
            setFalse();
            count = 0;
        }
        perg.setText(setCidade());
        cont.setText(count + "/21");
    }

    public void setFalse() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = false;
            }
        }
    }

    public String setCidade() {
        Boolean pode = true;
        do {
            x = (int) (Math.random() * 7);
            y = (int) (Math.random() * 3);
            if (!a[x][y]) {
                a[x][y] = true;
                pode = false;
                count++;
            }
        } while (pode);
        return cidades[x][y];
    }

    public static void main(String[] args) {
        new Papers();
    }

}
