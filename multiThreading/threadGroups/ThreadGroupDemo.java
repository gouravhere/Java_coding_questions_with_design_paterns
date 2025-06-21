package multiThreading.threadGroups;

public class ThreadGroupDemo {
    public static void main(String[] args) {
        //System.out.println(Thread.currentThread().getThreadGroup().getName());
        //System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
        //To Create new thread group
        ThreadGroup parent = new ThreadGroup("Parent Thread Group");
        ThreadGroup child = new ThreadGroup(parent, "Child Thread Group");
        System.out.println(child.getName());
        System.out.println(child.getParent().getName());
        child.setMaxPriority(3);
        //Setting priority of child thread group
        Thread thread1 = new Thread(child, "Thread 1");
        child.setMaxPriority(4);//Setting priority of child thread group to 2
        Thread thread2 = new Thread(child, "Thread 2");
        System.out.println(thread2.getThreadGroup().getName());
        System.out.println(thread2.getPriority());
        System.out.println(Thread.activeCount());
        parent.list();
        System.out.println();
    }
}
