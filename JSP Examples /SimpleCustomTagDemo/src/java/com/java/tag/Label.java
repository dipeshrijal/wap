/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Label extends SimpleTagSupport {

    String thecolor;

    public String getThecolor() {
        return thecolor;
    }

    public void setThecolor(String thecolor) {
        this.thecolor = thecolor;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }
    String words;

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        if (thecolor != null) {
            out.write(String.format("<spanstyle='color:%s'>%s</span>", thecolor, words));
        } else {
            out.write(String.format("<span>%s</span>", words));
        }
    }
}
