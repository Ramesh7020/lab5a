package lab5a;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class CountryListExample {

    public static void main(String[] args) {

        // Create Frame
        JFrame frame = new JFrame("Country JList Example");
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // List of Countries
        String countries[] = {
                "USA", "India", "Vietnam", "Canada", "Denmark",
                "France", "Great Britain", "Japan", "Africa",
                "Greenland", "Singapore"
        };

        // Create JList
        JList<String> countryList = new JList<>(countries);
        countryList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // Add Scroll Pane
        JScrollPane scrollPane = new JScrollPane(countryList);
        scrollPane.setPreferredSize(new Dimension(150, 200));

        // Add Listener
        countryList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    java.util.List<String> selected = countryList.getSelectedValuesList();

                    System.out.println("Selected Countries:");
                    for (String country : selected) {
                        System.out.println(country);
                    }
                    System.out.println("------------------");
                }
            }
        });

        // Add components to frame
        frame.add(scrollPane);

        // Make frame visible
        frame.setVisible(true);
    }
}