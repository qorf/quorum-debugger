/*
 Copyright (c) 2013, Andreas Stefik and Matt Pedersen
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions are met: 

 1. Redistributions of source code must retain the above copyright notice, this
 list of conditions and the following disclaimer. 
 2. Redistributions in binary form must reproduce the above copyright notice,
 this list of conditions and the following disclaimer in the documentation
 and/or other materials provided with the distribution. 

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

 The views and conclusions contained in the software and documentation are those
 of the authors and should not be interpreted as representing official policies, 
 either expressed or implied, of the FreeBSD Project.
 */
package org.debugger;

import org.debugger.jdi.JDIBreakpoint;
import org.debugger.jdi.JDIClassInformation;
import org.debugger.jdi.JDIDebugger;
import org.debugger.listeners.PrintListener;
import org.debugger.listeners.TimingListener;

/**
 * The Main class provides a bootup routine for basic testing of the debugger.
 * By default, this class takes one parameter, the full path name of a jar
 * to execute, which it then runs, beginning to end, firing off all events.
 * 
 * @author Andreas Stefik
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(args.length != 1) {
            return;
        }
        //for testing
        //"/Users/stefika/NetBeansProjects/QuorumApplication/Run/Default.jar"
        JDIDebugger debugger = new JDIDebugger();
        debugger.setExecutable(args[0]);

        //by default, pretty print the events
        TimingListener listener = new TimingListener();
        debugger.add(listener);        
        debugger.launch();
        debugger.forward();
    }
}
