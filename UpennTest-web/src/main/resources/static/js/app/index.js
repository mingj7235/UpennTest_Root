var main = {

    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.savePost();
        });

        $('#btn-update').on('click', function(){
            _this.updatePost();
        });

        $('#btn-delete').on('click', function(){
            _this.deletePost();
        });

        $('#btn-join').on('click', function(){
            _this.joinMember();
        });
    },
    savePost : function () {
        var data = {
            title : $('#title').val(),
            author : $('#author').val(),
            content : $('#content').val()
        };

        $.ajax({
            type : 'POST',
            url : '/api/boards',
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)

        }).done(function() {
            alert('글이 등록 완료 되었습니다.');
            window.location.href = '/';

        }).fail (function (error) {
            alert(JSON.stringify(error));
        });

    },

    updatePost : function () {
        var data = {
            title : $('#title').val(),
            content : $('#content').val()
        };
        var id = $('#id').val();
        var numId = parseInt(id);


        console.log (id);
        console.log (typeof(id));

        $.ajax({
            type : 'PUT',
            url : '/api/boards/'+id,
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)

        }).done(function() {
            alert('글 수정이 완료되었습니다. ');
            window.location.href = '/';

        }).fail (function (error) {
            alert(JSON.stringify(error));
        });
    },
    deletePost : function () {
        var id = $('#id').val();

        $.ajax ({
            type : 'DELETE',
            url : '/api/boards/'+id,
            dataType : 'json',
            contentType : 'application/json; charset=utf-8'
        }).done (function() {
            alert(id + '번글이 삭제되었습니다.');
            window.location.href = "/";
        }).fail (function(error) {
            alert("에러메세지 : " +JSON.stringify(error));
            console.log("에러메세지 : " +JSON.stringify(error));
        });
    },
    joinMember : function () {
        var data = {
            email : $('#email').val(),
            name : $('#memberName').val(),
            password : $('#password').val(),
            location_id : $('#location').val()
        };

        $.ajax ({
            type : 'POST',
            url : '/api/member/join',
            dataType :'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)        
        }).done (function() {
            alert('회원가입을 축하합니다.');
            window.location.href = "/";

        }).fail (function (error) {
            alert ('에러메세지 : ' + JSON.stringify(error));
        });
    }
};

main.init();
console.log('들어옴');

var input_value = $('#author').val()
console.log("value값 : "+typeof(input_value));
