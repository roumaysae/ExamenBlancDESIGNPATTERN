package com.roumaysae.entities;

import com.roumaysae.enums.TransactionType;

import java.util.Date;

public class Transaction {
    private String id;
    private Date date;
    private double montant;
    private TransactionType type;

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", montant=" + montant +
                ", type=" + type +
                '}';
    }

    public Transaction(String id, Date date, double montant, TransactionType type) {
        this.id = id;
        this.date = date;
        this.montant = montant;
        this.type = type;
    }

    private Transaction(TransactionBuilder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.montant = builder.montant;
        this.type = builder.type;
    }
    public static class TransactionBuilder {
        private String id;
        private Date date;
        private double montant;
        private TransactionType type;

        public TransactionBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public TransactionBuilder withDate(Date date) {
            this.date = date;
            return this;
        }

        public TransactionBuilder withMontant(double montant) {
            this.montant = montant;
            return this;
        }

        public TransactionBuilder withType(TransactionType type) {
            this.type = type;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }


    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public double getMontant() {
        return montant;
    }

    public TransactionType getType() {
        return type;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
}
