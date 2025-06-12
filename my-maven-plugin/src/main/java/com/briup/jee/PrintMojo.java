package com.briup.jee;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

/**
 * Goal which prints "Hello, Maven!"
 *
 * @goal print
 */
public class PrintMojo extends AbstractMojo {

    /**
     * @parameter expression="${name}" default-value="Maven"
     * @required
     */
    private String name;

    public void execute() throws MojoExecutionException {
        getLog().info("print, " + name + "!");
    }
}
