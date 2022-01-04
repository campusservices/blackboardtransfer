/*--

 $Id: Comment.java,v 1.33 2007/11/10 05:28:58 jhunter Exp $

 Copyright (C) 2000-2007 Jason Hunter & Brett McLaughlin.
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:

 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions, and the following disclaimer.

 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions, and the disclaimer that follows
    these conditions in the documentation and/or other materials
    provided with the distribution.

 3. The name "JDOM" must not be used to endorse or promote products
    derived from this software without prior written permission.  For
    written permission, please contact <request_AT_jdom_DOT_org>.

 4. Products derived from this software may not be called "JDOM", nor
    may "JDOM" appear in their name, without prior written permission
    from the JDOM Project Management <request_AT_jdom_DOT_org>.

 In addition, we request (but do not require) that you include in the
 end-user documentation provided with the redistribution and/or in the
 software itself an acknowledgement equivalent to the following:
     "This product includes software developed by the
      JDOM Project (http://www.jdom.org/)."
 Alternatively, the acknowledgment may be graphical using the logos
 available at http://www.jdom.org/images/logos.

 THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED.  IN NO EVENT SHALL THE JDOM AUTHORS OR THE PROJECT
 CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 SUCH DAMAGE.

 This software consists of voluntary contributions made by many
 individuals on behalf of the JDOM Project and was originally
 created by Jason Hunter <jhunter_AT_jdom_DOT_org> and
 Brett McLaughlin <brett_AT_jdom_DOT_org>.  For more information
 on the JDOM Project, please see <http://www.jdom.org/>.

 */

package org.jdom;

/**
 * An XML comment. Methods allow the user to get and set the text of the
 * comment.
 *
 * @version $Revision: 1.33 $, $Date: 2007/11/10 05:28:58 $
 * @author  Brett McLaughlin
 * @author  Jason Hunter
 */
public class Comment extends Content {

    private static final String CVS_ID =
      "@(#) $RCSfile: Comment.java,v $ $Revision: 1.33 $ $Date: 2007/11/10 05:28:58 $ $Name: jdom_1_1 $";

    /** Text of the <code>Comment</code> */
    protected String text;

    /**
     * Default, no-args constructor for implementations to use if needed.
     */
    protected Comment() {}

    /**
     * This creates the comment with the supplied text.
     *
     * @param text <code>String</code> content of comment.
     */
    public Comment(String text) {
        setText(text);
    }


    /**
     * Returns the XPath 1.0 string value of this element, which is the
     * text of this comment.
     *
     * @return the text of this comment
     */
    public String getValue() {
        return text;
    }

    /**
     * This returns the textual data within the <code>Comment</code>.
     *
     * @return <code>String</code> - text of comment.
     */
    public String getText() {
        return text;
    }

    /**
     * This will set the value of the <code>Comment</code>.
     *
     * @param text <code>String</code> text for comment.
     * @return <code>Comment</code> - this Comment modified.
     * @throws IllegalDataException if the given text is illegal for a
     *         Comment.
     */
    public Comment setText(String text) {
        String reason;
        if ((reason = Verifier.checkCommentData(text)) != null) {
            throw new IllegalDataException(text, "comment", reason);
        }

        this.text = text;
        return this;
    }

    /**
     * This returns a <code>String</code> representation of the
     * <code>Comment</code>, suitable for debugging. If the XML
     * representation of the <code>Comment</code> is desired,
     * {@link org.jdom.output.XMLOutputter#outputString(Comment)}
     * should be used.
     *
     * @return <code>String</code> - information about the
     *         <code>Attribute</code>
     */
    public String toString() {
        return new StringBuffer()
            .append("[Comment: ")
            .append(new org.jdom.output.XMLOutputter().outputString(this))
            .append("]")
            .toString();
    }

}
