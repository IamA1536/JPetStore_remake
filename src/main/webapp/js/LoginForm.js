document.getElementById("btn").onclick = function (obj) {

    var timenow = new Date().getTime();
    //ÿ��������Ҫһ����ͬ�Ĳ�����������ܻ᷵��ͬ������֤��
    //���������Ļ�������й�ϵ��Ҳ���԰�ҳ������Ϊ�����棬�����Ͳ�����������ˡ�
    obj.src = "securityCode.action?d=" + timenow;
    
};