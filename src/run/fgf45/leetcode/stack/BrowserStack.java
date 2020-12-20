package run.fgf45.leetcode.stack;

/**
 * 浏览器栈
 */
public class BrowserStack {

    LinkListStack backStack = new LinkListStack();
    LinkListStack forwardStack = new LinkListStack();

    protected void enter(Integer v) {
        backStack.push(v);
        forwardStack.clear();
    }

    protected void back() {
        LinkListStack.Node node = (LinkListStack.Node) backStack.pop();
        forwardStack.push(node.getData());
    }

    protected void forward() {
        LinkListStack.Node node = (LinkListStack.Node) forwardStack.pop();
        backStack.push(node.getData());
    }

    public static void main(String[] args) {
        BrowserStack browserStack = new BrowserStack();
        browserStack.enter(1);
        browserStack.enter(2);
        browserStack.enter(3);
        browserStack.back();
        browserStack.enter(4);
    }


}
