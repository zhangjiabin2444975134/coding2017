package jvm.cmd;

import jvm.clz.ClassFile;
import jvm.constant.ConstantInfo;
import jvm.constant.ConstantPool;
import jvm.constant.StringInfo;
import jvm.constant.UTF8Info;
import jvm.engine.ExecutionResult;
import jvm.engine.Heap;
import jvm.engine.JavaObject;
import jvm.engine.StackFrame;

public class LdcCmd extends OneOperandCmd {

	public LdcCmd(ClassFile clzFile,String opCode) {
		super(clzFile,opCode);		
	}
	
	@Override
	public String toString(ConstantPool pool) {
		
		ConstantInfo info = (ConstantInfo)pool.getConstantInfo(this.getOperand());
		
		String value = "TBD";
		if(info instanceof StringInfo){
			StringInfo strInfo = (StringInfo)info;
			value = strInfo.toString();
		}
		
		return this.getOffset()+":"+this.getOpCode()+" " + this.getReadableCodeText() + " "+  value;
		
	}

	@Override
	public void execute(StackFrame frame, ExecutionResult result) {
		ConstantPool pool = this.getConstantPool();
		ConstantInfo info = (ConstantInfo)pool.getConstantInfo(this.getOperand());
		
		if(info instanceof StringInfo){
			StringInfo strInfo = (StringInfo)info;
			String value = strInfo.toString();
			JavaObject jo = Heap.getInstance().newString(value);
			frame.getOprandStack().push(jo);
		}
		else{
			//TBD 处理其他类型
			throw new RuntimeException("Only support StringInfo constant");
		}
	}
	
}
