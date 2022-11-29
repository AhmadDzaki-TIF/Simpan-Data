package BerkasBank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BerkasBank {
    private JTextField NoKartu;
    private JComboBox JenisATM;
    private JComboBox Bank;
    private JTextField NamaPemilik;
    private JButton Simpan;
    private JButton PilihFile;
    private JLabel TeksGambar;
    private JTextArea OutputLine;
    private JPanel Haha;

    public String fileName;

    public void insertingDataToFile(String inputtedData) throws IOException {
        try {
            FileWriter myFile = new FileWriter("fileData.txt", true);
            myFile.write(inputtedData);
            myFile.close();
            System.out.println("Succesfully wrote to the file");
        } catch (IOException ex) {
            System.out.println("An error occured");
            ex.printStackTrace();
        }
    }

    public BerkasBank() {
        Simpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String no = NoKartu.getText();
                String atm = (String) JenisATM.getSelectedItem();
                String bank = (String) Bank.getSelectedItem();
                String nama = NamaPemilik.getText();

                Data data = new Data();
                data.setNo(no);
                data.setAtm(atm);
                data.setBank(bank);
                data.setNama(nama);

                String hasil = "Saved!" + "\nNo Kartu = " + no + "\nJenis ATM = " + atm + "\nBank = " + bank +
                        "\nNama Pemilik = " + nama + "\nNama File Gambar = " + fileName;

                OutputLine.append(hasil);
            }
        });
        PilihFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser PilihFile = new JFileChooser();

                int showOpenDialogue = PilihFile.showOpenDialog(null);

                if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
                    fileName = PilihFile.getSelectedFile().getName();

                    File selectedImage = PilihFile.getSelectedFile();
                    String selectedImagePath = selectedImage.getAbsolutePath();

                    ImageIcon ii = new ImageIcon(selectedImagePath);
                    Image image = ii.getImage().getScaledInstance(TeksGambar.getWidth(), TeksGambar.getHeight(), Image.SCALE_SMOOTH);

                    TeksGambar.setIcon(new ImageIcon(image));
                }

            }
        });

    }
    public JPanel getHaha() {
        return Haha;
    }
}
