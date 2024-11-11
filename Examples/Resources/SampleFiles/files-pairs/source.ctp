<!-- src/Template/Posts/view.ctp -->
<?php
$this->extend('/Common/view');

$this->assign('title', $post->title);

$this->start('sidebar');
?>
<li>
<?php
echo $this->Html->link('edit', [
    'action' => 'edit',
    $post->id
]);
?>
</li>
<?php $this->end(); ?>

// Остальное содержимое будет доступно как блок 'content'
// в родительском представлении.
<?= h($post->body) ?>