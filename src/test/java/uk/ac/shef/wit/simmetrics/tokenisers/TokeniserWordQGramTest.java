/**
 * SimMetrics - SimMetrics is a java library of Similarity or Distance
 * Metrics, e.g. Levenshtein Distance, that provide float based similarity
 * measures between String Data. All metrics return consistant measures
 * rather than unbounded similarity scores.
 *
 * Copyright (C) 2005 Sam Chapman - Open Source Release v1.1
 *
 * Please Feel free to contact me about this library, I would appreciate
 * knowing quickly what you wish to use it for and any criticisms/comments
 * upon the SimMetric library.
 *
 * email:       s.chapman@dcs.shef.ac.uk
 * www:         http://www.dcs.shef.ac.uk/~sam/
 * www:         http://www.dcs.shef.ac.uk/~sam/stringmetrics.html
 *
 * address:     Sam Chapman,
 *              Department of Computer Science,
 *              University of Sheffield,
 *              Sheffield,
 *              S. Yorks,
 *              S1 4DP
 *              United Kingdom,
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package uk.ac.shef.wit.simmetrics.tokenisers;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: mpkorstanje
 * Date: 14-Dec-2014
 * Time: 14:49:30
 * To change this template use File | Settings | File Templates.
 */
public class TokeniserWordQGramTest  extends TestCase {

    /**
     * internal tokeniser.
     */
    private InterfaceTokeniser tokeniser = null;

    /**
     * main constructor setting the name of the test case.
     *
     * @param s The name of the test
     */
    public TokeniserWordQGramTest(String s) {
        super(s);
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp() {
        tokeniser = new TokeniserWordQGram();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown() {
        // release objects under test here, if necessary
    }

    /**
     * Tests the tokenizer.
     */
    public void testTokeniseToArrayList() {
        ArrayList<String> results = tokeniser.tokenizeToArrayList("1234 5678 90 a") ;
        System.out.println(results);
        assertEquals(7, results.size());
        assertEquals("12", results.get(0));
        assertEquals("23", results.get(1));
        assertEquals("34", results.get(2));

        assertEquals("56", results.get(3));
        assertEquals("67", results.get(4));
        assertEquals("78", results.get(5));
        
        assertEquals("90", results.get(6));

        assertFalse(results.contains("a"));

    }
    
    /**
     * Tests the tokenizer.
     */
    public void testTokeniseToSet() {
        Set<String> results = tokeniser.tokenizeToSet("1234 1234 90 a") ;
        System.out.println(results);
        assertEquals(4, results.size());
        assertTrue(results.contains("12"));
        assertTrue(results.contains("23"));
        assertTrue(results.contains("34"));

        assertTrue(results.contains("90"));

        assertFalse(results.contains("a"));

    }
}