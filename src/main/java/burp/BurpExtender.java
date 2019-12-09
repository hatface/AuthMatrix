package burp;

import com.knightsoft.data.MatrixDB;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BurpExtender implements IBurpExtender, ITab, IContextMenuFactory, IMessageEditorController {

    //db
    private MatrixDB db = new MatrixDB();

    public MatrixDB getDb() {
        return db;
    }

    public void setDb(MatrixDB db) {
        this.db = db;
    }

    //implements IBurpExtender
    @Override
    public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks) {

    }

    //implements IContextMenuFactory
    @Override
    public List<JMenuItem> createMenuItems(IContextMenuInvocation invocation) {
        return null;
    }

    //implements IMessageEditorController
    @Override
    public IHttpService getHttpService() {
        return null;
    }

    @Override
    public byte[] getRequest() {
        return new byte[0];
    }

    @Override
    public byte[] getResponse() {
        return new byte[0];
    }

    //implements ITab
    @Override
    public String getTabCaption() {
        return null;
    }

    @Override
    public Component getUiComponent() {
        return null;
    }
}
