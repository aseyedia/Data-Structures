/**
 * Graph class. Stores list of the vertices in each matrix.
 * 
 * @author arta
 *
 */
public class Graph
    {
        private Vertex[] vertBank;
        private int vertBankSize;
        private int root;

        /**
         * Basically the same as vertBank.length - Is the int size of the list
         * of vertices
         * 
         * @param dims
         *            Matrix length/width
         */
        public void setVertBankSize(int dims)
            {
                this.vertBankSize = dims;
                vertBank = new Vertex[vertBankSize];
            }

        /**
         * Sets a vertex at a given position in vertBank
         * 
         * @param id
         *            Row number/identifier of vertex
         * @param vert
         *            Vertex object
         */
        public void setVert(int id, Vertex vert)
            {
                vertBank[id] = vert;
            }

        /**
         * Sets a vertex id as the root vertex, the one which the path started
         * from. Allows for the root node to get printed if traversed upon
         * during the path to indicate termination.
         * 
         * @param id
         *            Root vertex id
         */
        public void setRootVert(int id)
            {
                this.root = id;
            }

        // IMPORTANT: this method counts as 'visited' even if
        // you start on that node. fix it.
        /**
         * This method, deepSearch, is basically a depth-first search which I
         * learned about independently from this course. Supplied with a
         * vertex id, stack, and root, this method finds every possible
         * combination of vertices in the path from the starting vertex.
         * 
         * @param id
         *            Row id indicating vertex
         * @param root
         *            Allows the occurrence of a root node to be processed if
         *            happening after the initial vertex
         * @param stack
         *            Stack which stores path information
         */
        public void deepSearch(int id, boolean root, Stack stack)
            {
                // Mark the current node as visited and print it

                if (!stack.contains(id))
                    {
                        stack.push(id);

                        stack.print();

                        // Recur for all the vertices adjacent to this vertex
                        // Implement a hasNext and next for the vertices
                        for (int q = 0; q < vertBankSize; q++)
                            {
                                // changed to reading each node's binary value
                                if (vertBank[id].getConn(q)
                                        .getBinValue() == 1)
                                    {
                                        root = false;
                                        deepSearch(
                                                vertBank[id].getConn(q)
                                                        .getNextVert(),
                                                root, stack);
                                        // deleting of the backtracked node
                                        if (q == vertBankSize - 1)
                                            {
                                                stack.pop();
                                            }
                                        // deleting of the backtracked node
                                        // but
                                        // if getConn(q) != 1 but is still
                                        // exhausted
                                    } else if (q == vertBankSize - 1)
                                    {
                                        stack.pop();

                                    } else if (vertBank[id].getConn(q)
                                            .getBinValue() == 0)
                                    {
                                        System.out.print("XX NOT FOUND: ");
                                        System.out.println(stack.sPrint(q));
                                    }
                            }

                    } else if (id == this.root)
                    {
                        stack.push(id);
                        stack.print();
                        stack.pop();
                        return;
                    }

                else if (stack.contains(id))
                    {
                        System.out.print("XX ALREADY VISITED: ");
                        System.out.println(stack.sPrint(id));
                    } else
                    {

                    }
            }

        // The function to do DFS traversal. It uses recursive DFSUtil()
        /**
         * This method calls deepSearch, supplied with a row id to text every
         * scenario with that as the starting vertex
         * 
         * @param id
         *            Row identifier
         */
        public void deepSearchCall(int id)
            {
                // Mark all the vertices as not visited(set as
                // false by default in java)
                boolean visited[] = new boolean[vertBankSize];
                boolean root = true;
                // Call the recursive helper function to print DFS traversal
                setRootVert(id);
                Stack kew = new Stack();
                deepSearch(id, root, kew);

            }

        /**
         * A stack class defined within the graph class. Used to store paths.
         * 
         * @author Arta
         *
         */
        class Stack
            {
                int[] path = new int[50];
                int bottom = 0;
                int top = 0;

                /**
                 * Places the integer value corresponding to the vertex id to
                 * the top of the stack.
                 * 
                 * @param vert
                 *            The id of the vertex to be pushed
                 */
                public void push(int vert)
                    {
                        path[top] = vert;
                        top++;
                    }

                /**
                 * Returns and deletes the item on the top of the stack.
                 * 
                 * @return The vertex id of the top-most item in stack
                 */

                public int pop()
                    {

                        return path[top--];

                    }

                /**
                 * Prints the entirety of the path.
                 * 
                 */
                public void print()
                    {
                        for (int i = bottom; i < top; i++)
                            {

                                System.out.print(path[i] + " ");

                            }
                        System.out.println();
                    }

                /**
                 * Special print method in instances where the id is not
                 * appended to the path but must be printed with the rest of
                 * the path nonetheless e.g. when there is no path connecting
                 * them.
                 * 
                 * @param id
                 *            The vertex identifier
                 * @return String which contains the whole path including the
                 *         vertex was not pushed
                 */
                public String sPrint(int id)
                    {
                        String real = "";
                        for (int i = bottom; i < top; i++)
                            {

                                real = real.concat(Integer.toString(path[i]))
                                        + " ";
                            }
                        real = real.concat(Integer.toString(id));
                        return real;
                    }

                /**
                 * Returns true if target vertex is not in the path.
                 * 
                 * @param targ
                 *            The id of the target vertex
                 * @return True if contained, false if not
                 */
                public boolean contains(int targ)
                    {
                        for (int i = 0; i < top; i++)
                            {
                                if (path[i] == targ)
                                    {

                                        return true;
                                    }

                            }
                        return false;
                    }

            }

    }
