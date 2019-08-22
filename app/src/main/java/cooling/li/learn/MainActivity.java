package cooling.li.learn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import cooling.li.learn.util.Utils;
import okio.Buffer;
import okio.Okio;
import okio.Source;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ioGenerate();
//        okio();

        try {
            Class utlClass = Utils.class;
            Object util = utlClass.newInstance();
            Method method = utlClass.getDeclaredMethod("shot");
            method.invoke(util);

            Class utilCLass = Class.forName("cooling.li.learn.util.Utils");
            Constructor constructor = utilCLass.getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            Object utils = constructor.newInstance();
            Method method1 = utilCLass.getDeclaredMethod("shot");
            method1.setAccessible(true);
            method1.invoke(utils);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void ioGenerate() {
        File file = new File("./Learn/io.txt");
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write("测试io的专题");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void okio(){
        try {
            Source source = Okio.source(new File("./Learn/io.txt"));
            Buffer buffer = new Buffer();
            source.read(buffer,1024);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
