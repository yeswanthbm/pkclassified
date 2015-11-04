freeStyleJob('freestyle job') {
    scm {
	svn {
		location('https://svn2.prokarma.com/svn/dockertestapp/branches/junitmavenexample') {
                directory('proj2')
                depth(SvnDepth.EMPTY)
            }
        wrappers {
           credentials{
            username('username')
            password('PASSWORD')
           }
        }
        }
	
    }
    steps {
        maven('clean install')
    }
}

