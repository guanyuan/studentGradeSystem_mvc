作业反馈
======================

## Well

1. 代码格式有很大进步，更规范了

## Less Well

1. 学会使用gitignore，将没必要放到代码仓库的文件ignore掉，比如
    -- idea的工程文件*.iml, *.ipr, *. iws
    -- 构件输出文件夹build(gradle的)，out(idea的)
    -- gradle相关文件夹
2. guava要使用最新版本的，13已经很老了
3. Java程序要使用包进行管理，不要直接将class放到source目录下（这里是/src/main/java和/src/test/java），反映在代码上面就是java类中没用使用package。
4. Java里面的域变量一定要明确他的可访问性，明确写出应该是public（全局可见）/private（只有自己可见）/(不写，代表只有同一个包可见)/protected（同一个包和子类可见），并且尽可能是可访问性最小。比如StudentGradeTest.java的studentA, studentB, studentC, studentD, 4. Java里面的域变量一定要明确他的可访问性，明确写出应该是public（全局可见）/private（只有自己可见）/(不写，代表只有同一个包可见)/protected（同一个包和子类可见），比如StudentGradeTest.java的studentA, studentB, studentC, studentD, studentCollection, studentView，都应该是private的。
5. 不要将多个变量声明在同一行，应该分开到不同的行。比如：Student studentA, studentB, studentC, studentD;
6. 不要把只在一个方法里面用到的变量提出来成为域变量，比如：studentB, studentC，他们只在setUp方法中用到了，应该转换成局部变量，更进一步，他们只是被放到了studentCollection中，应该内联。
