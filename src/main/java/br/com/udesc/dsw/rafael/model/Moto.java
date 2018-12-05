/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.br.com.udesc.dsw.rafael.model;


public class Moto {
        private String montadora;
    private String modelo;
    private String cor;
    private int quilometragem;
    private double motor;     

    public Moto(String montadora, String modelo, String cor, int quilometragem, double motor) {
        this.montadora = montadora;
        this.modelo = modelo;
        this.cor = cor;
        this.quilometragem = quilometragem;
        this.motor = motor;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public double getMotor() {
        return motor;
    }

    public void setMotor(double motor) {
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "Moto{" + "montadora=" + montadora + ", modelo=" + modelo + ", cor=" + cor + ", quilometragem=" + quilometragem + ", motor=" + motor + '}';
    }



}
