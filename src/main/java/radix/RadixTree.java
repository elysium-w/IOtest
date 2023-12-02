package radix;

class RadixNode {
    public char c;
    public boolean isEnd;
    public RadixNode[] children;
    public RadixNode(){
        this.c=c;
        this.children=new RadixNode[26];
        this.isEnd =false;
    }
}
public class RadixTree {
    private RadixNode root;
    public RadixTree(){
        this.root=new RadixNode();
    }
    public void insert(String word){
        RadixNode node=root;
        for (char c:word.toCharArray()){
            if (node.children[c-'a']==null){
                node.children[c-'a']=new RadixNode();
                node.children[c-'a'].c=c;
            }
            node.children[c].c=c;
        }
        node.isEnd =true;
    }
    public void delete(String word){
        if (word.isEmpty()){
            root.isEnd =false;
        }else {
            deleteHelp(root,word);
        }

    }
    private boolean deleteHelp(RadixNode node,String word){
        if (!node.isEnd&&node!=root){

        }

    }

    public static void main(String[] args) {

    }
}
