'use strict';

$(document).ready(function(){

    $(document).on('click','#example .delete-student', function(){
        let id = $(this).attr('id');
        $.confirm({
            title:'Delete Student',
            content:'Are you sure you want to delete student?',
            type:'red',
            icon:'fa-regular fa-face-frown fa-lg',
            buttons:{
                submit:{
                    text:'Delete',
                    btnClass:'btn btn-danger',
                    action:function(){
                        fetch('/delete/'+id,{
                            method:'get'
                        }).then(response=>response.json())
                        .then(data=> console.log(data));
                    }
                },
                close:{
                    text:'Close',
                    btnClass:'btn btn-secondary',
                    action:function(){}
                }
            }
        });
    });

});