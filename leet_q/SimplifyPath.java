class Solution {
    public String simplifyPath(String path) {
        path = path + "/";
        Stack<String> shortestPath = new Stack<String>();
        int previousSlash = 0;
        for (int i = 1; i < path.length(); i++){
            if (path.charAt(i) == '/'){
                String directoryString = path.substring(previousSlash + 1, i);
                if ("..".equals(directoryString)){
                    if (shortestPath.size() > 0){
                        shortestPath.pop();
                    }
                } else if (".".equals(directoryString)){

                } else if ("".equals(directoryString)){

                } else {
                    shortestPath.push(directoryString);
                }
                previousSlash = i;
            }
        }
        String[] directories = shortestPath.toArray(new String[0]);
        return "/" + String.join("/", directories);
    }
}