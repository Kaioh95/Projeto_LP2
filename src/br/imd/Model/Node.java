package br.imd.Model;

public class Node {
    private double key;
    private String[] content;

    public Node(){ }

    public Node(double key, String[] content) {
        this.key = key;
        this.content = content;
    }

    public double getKey() {
        return key;
    }

    public void setKey(double key) {
        this.key = key;
    }

    public String[] getContent() {
        return content;
    }

    public void setContent(String[] content) {
        this.content = content;
    }

    @Override
    public String toString(){
        return "Distância: " + key + ", " + content[content.length-1] + "\n";
    }
}
