package com.briup.jee;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

/**
 * Goal which prints "Hello, Maven!"
 *
 * @goal hello
 */
public class HelloMojo extends AbstractMojo {

    /**
     * @parameter expression="${name}" default-value="Maven"
     * @required
     */
    private String name;

    public void execute() throws MojoExecutionException {
        getLog().info("Hello, " + name + "!");
    }
}
