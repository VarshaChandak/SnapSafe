import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageOperation{

    public static void operate(int key, boolean isEncrypt) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();

        if (file == null) {
            JOptionPane.showMessageDialog(null, "No file selected.");
            return;
        }

        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[fis.available()];
            fis.read(data);
            fis.close();

            for (int i = 0; i < data.length; i++) {
                data[i] = (byte) (data[i] ^ key);
            }

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();

            String message = isEncrypt ? "Image Encrypted Successfully!" : "Image Decrypted Successfully!";
            JOptionPane.showMessageDialog(null, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Encryption & Decryption");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.setLocationRelativeTo(null);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel label = new JLabel("Enter Key:");
        label.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(label, gbc);

        JTextField textField = new JTextField(10);
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        frame.add(textField, gbc);

        JButton encryptButton = new JButton("Encrypt Image");
        encryptButton.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(encryptButton, gbc);

        JButton decryptButton = new JButton("Decrypt Image");
        decryptButton.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 1;
        frame.add(decryptButton, gbc);

        encryptButton.addActionListener(e -> {
            try {
                int key = Integer.parseInt(textField.getText());
                operate(key, true);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric key.");
            }
        });

        decryptButton.addActionListener(e -> {
            try {
                int key = Integer.parseInt(textField.getText());
                operate(key, false);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric key.");
            }
        });

        frame.setVisible(true);
    }
}
