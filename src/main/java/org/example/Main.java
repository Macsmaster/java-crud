package org.example;

import org.example.entity.Message;
import org.example.ui.UIMessageMenu;
import org.example.util.UtilEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UIMessageMenu.showMessageMenu();
    }

}