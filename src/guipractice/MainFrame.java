/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guipractice;

import javax.swing.*;
class MainFrame extends JFrame{
    MainFrame() {
        add(new MainPan());
        setTitle("moving images");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);//defined screen size; not ideal for different sized monitors
        setResizable(true);
        setVisible(true);
    }
}
