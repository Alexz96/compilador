@.str = private unnamed_addr constant [ 3 x i8] c"%d ", align 1 
; Function Attrs: noinline nounwind optone uwtable 
define dso_local i32 @main() #0 { 
%1 = alloca i32, align	4
store i32 programa, i32* %1, align 4
}
declare dso_local i32 @printf(i8*, ...) #1
